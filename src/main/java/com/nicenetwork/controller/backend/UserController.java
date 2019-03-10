package com.nicenetwork.controller.backend;

import com.nicenetwork.model.Profile;
import com.nicenetwork.model.User;
import com.nicenetwork.service.ProfileService;
import com.nicenetwork.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by gsp on 12/07/2016.
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;

    @RequestMapping(value = "backend/user", method = RequestMethod.GET)
    public String index(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "searchKeyword", defaultValue = "", required = false) String searchKeyword,
            Model model) {

        List<User> user = userService.getData(page, searchKeyword);
        for (User u : user) {
            System.out.println(u.toString());
        }

        model.addAttribute("list_data", user);
        model.addAttribute("startpage", page / 5);

        System.out.println("========================================");
        System.out.println("start page = " + page / 5 + "|| end page = " + userService.getMaxCount(searchKeyword) / 5 + "|| maxcount= " + userService.getMaxCount(searchKeyword));
        System.out.println("========================================");
        if (userService.getMaxCount(searchKeyword) % 5 == 0)
        {
            model.addAttribute("endpage", (userService.getMaxCount(searchKeyword) / 5) - 1);
        }
        else
        {
            model.addAttribute("endpage", userService.getMaxCount(searchKeyword) / 5);
        }
        model.addAttribute("href", "?searchKeyword=" + searchKeyword + "&page=");
        model.addAttribute("count", userService.getMaxCount(searchKeyword));

        return "user.index.template";
    }

    @RequestMapping(value = "backend/user/insert", method = RequestMethod.GET)
    public String insert() {
        return "user.insert.template";
    }

    @RequestMapping(value = "backend/user/insert", method = RequestMethod.POST)
    public String inserting(
            Model model,
            @RequestParam(value = "username", defaultValue = "") String username,
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "birthplace", defaultValue = "") String birthplace,
            @RequestParam(value = "birthday", defaultValue = "") String birthday,
            @RequestParam(value = "address", defaultValue = "") String address,
            @RequestParam(value = "phone", defaultValue = "") String phone,
            @RequestParam("photo") MultipartFile photo) {


        if (photo.getSize() > 1000000) {
            model.addAttribute("Message", "File To Large");
            return "backend/user/insert";
        } else {

            try {

                User paramUser = new User();
                Profile paramProfile = new Profile();
                String fileName = null;
                fileName = photo.getOriginalFilename();

                if (!photo.isEmpty()) {
                    try {

                        byte[] bytes = photo.getBytes();
                        BufferedOutputStream buffStream =
                                new BufferedOutputStream(new FileOutputStream(new File("/" + "nicenetwork_file" + "/" + fileName)));
                        buffStream.write(bytes);
                        paramProfile.setPhoto(fileName);
                        buffStream.close();

                    } catch (Exception e) {
                        model.addAttribute("Message", e.getCause().getMessage());
                        return "backend/user/insert";
                    }
                }


                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashedPassword = passwordEncoder.encode(password);


                paramUser.setUsername(username);
                paramUser.setPassword(hashedPassword);
                paramUser.setActive(1);

                paramProfile.setUser(paramUser);
                paramProfile.setEmail(email);
                paramProfile.setUser_name(username);
                paramProfile.setBirthplace(birthplace);
                paramProfile.setBirthday(birthday);
                paramProfile.setAddress(address);
                paramProfile.setPhone(phone);
                paramProfile.setRole("ROLE_ADMIN");

                paramUser.setProfile(paramProfile);
                userService.save(paramUser);

                model.addAttribute("Message", "Data Saved");
            } catch (Exception ex) {
                ex.getMessage();
                model.addAttribute("Message", ex.getCause().getMessage());
            }

            return "user.insert.template";
        }
    }

    @RequestMapping(value = "backend/user/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") Integer id) {
        try {
            model.addAttribute("list_data", userService.getData(id));
            model.addAttribute("list_data_profile", profileService.getData(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user.edit.template";
    }

    @RequestMapping(value = "backend/user/edit", method = RequestMethod.POST)
    public String editing(
            @RequestParam(value = "id", defaultValue = "") int id,
            @RequestParam(value = "id_profile", defaultValue = "") int idProfile,
            @RequestParam(value = "username", defaultValue = "") String username,
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "birthplace", defaultValue = "") String birthplace,
            @RequestParam(value = "birthday", defaultValue = "") String birthday,
            @RequestParam(value = "address", defaultValue = "") String address,
            @RequestParam(value = "phone", defaultValue = "") String phone,
            @RequestParam("photo") MultipartFile photo,
            Model model,
            RedirectAttributes attr) {

        if (photo.getSize() > 1000000) {
            attr.addFlashAttribute("Message", "File To Large");
            return "redirect:/backend/user/edit/" + id;
        } else {
            String fileName = null;
            User paramUser = new User();
            User param2 = userService.getData(paramUser.getId());
            Profile paramProfile = new Profile();
            User param = userService.getData(id);
            fileName = photo.getOriginalFilename();

            if (!photo.isEmpty()) {
                try {
                    byte[] bytes = photo.getBytes();
                    BufferedOutputStream buffStream =
                            new BufferedOutputStream(new FileOutputStream(new File("/" + "nicenetwork_file" + "/" + fileName)));
                    buffStream.write(bytes);
                    buffStream.close();
                    paramProfile.setPhoto(fileName);

                    File file = new File("/" + "nicenetwork_file" + "/" + param.getProfile().getPhoto());
                    file.delete();

                } catch (Exception e) {
                    attr.addFlashAttribute("Message", e.getCause().getMessage());
                    return "redirect:/backend/user/edit/" + id;
                }
            } else {
                paramProfile.setPhoto(param.getProfile().getPhoto());
            }

            try {

                paramUser.setId(id);
                paramUser.setUsername(username);
                paramUser.setActive(1);


                String pwd = param.getPassword();
                if (!password.equalsIgnoreCase("")) {
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    String hashedPassword = passwordEncoder.encode(password);
                    paramUser.setPassword(hashedPassword);
                } else {
                    paramUser.setPassword(pwd);
                }


                paramProfile.setUser(paramUser);
                paramProfile.setEmail(email);
                paramProfile.setUser_name(username);
                paramProfile.setId(idProfile);
                paramProfile.setBirthplace(birthplace);
                paramProfile.setBirthday(birthday);
                paramProfile.setAddress(address);
                paramProfile.setPhone(phone);
                paramProfile.setRole("ROLE_ADMIN");

                paramUser.setProfile(paramProfile);
                userService.edit(paramUser);

                attr.addFlashAttribute("Message", "Data Edited");

            } catch (Exception ex) {
                attr.addFlashAttribute("Message", "Error Edit Data");
            }

            model.addAttribute("list_data", param2);
            return "redirect:/backend/user/edit/" + id;
        }


    }

    @RequestMapping(value = "backend/user/delete/{id}", method = RequestMethod.GET)
    public String deleting(@PathVariable("id") Integer id, RedirectAttributes attr) {

        try {
            User param = userService.getData(id);
            File file = new File("/" + "nicenetwork_file" + "/" + param.getProfile().getPhoto());
            file.delete();
            userService.delete(param);
            attr.addFlashAttribute("Message", "Data has been delete");
        } catch (Exception ex) {
            ex.getMessage();
            attr.addFlashAttribute("Message", ex.getCause().getMessage());
        }
        return "redirect:/backend/user";
    }

}
