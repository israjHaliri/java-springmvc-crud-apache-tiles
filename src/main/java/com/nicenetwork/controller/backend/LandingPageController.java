package com.nicenetwork.controller.backend;

import com.nicenetwork.dao.LandingPageDao;
import com.nicenetwork.model.LandingPage;
import com.nicenetwork.model.Profile;
import com.nicenetwork.model.User;
import com.nicenetwork.service.FileService;
import com.nicenetwork.service.LandingPageService;
import com.nicenetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by gsp on 12/07/2016.
 */

@Controller
public class LandingPageController {

    @Autowired
    LandingPageDao landingPageService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "backend/landing_page", method = RequestMethod.GET)
    public String index(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "searchKeyword", defaultValue = "", required = false) String searchKeyword,
            Model model) {

        int countpage = 0;

        countpage = page * 5;

        List<LandingPage> param = landingPageService.getData(countpage, 5, searchKeyword);
        model.addAttribute("list_data", param);

        model.addAttribute("startpage", page / 5);

        if (landingPageService.getCount(searchKeyword) % 5 == 0)
        {
            model.addAttribute("endpage", (landingPageService.getCount(searchKeyword)/5) - 1);
        }
        else
        {
            model.addAttribute("endpage", landingPageService.getCount(searchKeyword)/5);
        }

        model.addAttribute("href", "?searchKeyword=" + searchKeyword + "&page=");

        return "landing_page.index.template";
    }

    @RequestMapping(value = "backend/landing_page/insert", method = RequestMethod.GET)
    public String insert() {
        return "landing_page.insert.template";
    }

    @RequestMapping(value = "backend/landing_page/insert", method = RequestMethod.POST)
    public String inserting(Model model,@ModelAttribute LandingPage landingPage) {

            try {

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();

                landingPage.setCreated_at(date);
                landingPage.setUpdate_at(date);

                landingPageService.saveOrUpdate(landingPage);
                model.addAttribute("Message", "Data Saved");
            } catch (Exception ex) {
                ex.getMessage();
                model.addAttribute("Message", ex.getCause().getMessage());
            }

            return "landing_page.insert.template";
    }

    @RequestMapping(value = "backend/landing_page/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") Integer id) {
        try {
            model.addAttribute("list_data", landingPageService.getDataById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "landing_page.edit.template";
    }

    @RequestMapping(value = "backend/landing_page/edit", method = RequestMethod.POST)
    public String editing(Model model,@ModelAttribute LandingPage landingPage,@RequestParam(value = "id", defaultValue = "") int id,RedirectAttributes attr) {

            try {
                landingPage.setId(id);
                landingPageService.saveOrUpdate(landingPage);
                attr.addFlashAttribute("Message", "Data Edited");

            } catch (Exception ex) {
                model.addAttribute("Message", ex.getCause().getMessage());
            }

            LandingPage  param2 = landingPageService.getDataById(landingPage.getId());
            model.addAttribute("list_data", param2);
            return "redirect:/backend/landing_page/edit/" + landingPage.getId();
    }


    @RequestMapping(value = "backend/landing_page/delete/{id}", method = RequestMethod.GET)
    public String deleting(@PathVariable("id") Integer id, RedirectAttributes attr) {

        try {

            List<com.nicenetwork.model.File> param = fileService.getData(0, fileService.getCount("",id), "",id);
            for (com.nicenetwork.model.File file : param)
            {
                java.io.File filedir = new java.io.File("/" + "nicenetwork_file" + "/" + file.getParent_id() +"/"+ file.getFile());
                filedir.delete();
                java.io.File filedirparent = new java.io.File("/" + "nicenetwork_file" + "/" + file.getParent_id());
                filedirparent.delete();
            }


            java.io.File file = new java.io.File("/" + "nicenetwork_file/" + "26");
            file.delete();
            landingPageService.delete(id);
            attr.addFlashAttribute("Message", "Data has been delete");
        } catch (Exception ex) {
            ex.getMessage();
            attr.addFlashAttribute("Message", ex.getCause().getMessage());
        }
        return "redirect:/backend/landing_page";
    }

}
