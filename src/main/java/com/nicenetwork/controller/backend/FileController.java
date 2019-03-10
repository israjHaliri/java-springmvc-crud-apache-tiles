package com.nicenetwork.controller.backend;

import com.nicenetwork.dao.FileDao;
import com.nicenetwork.dao.LandingPageDao;
import com.nicenetwork.model.File;
import com.nicenetwork.model.LandingPage;
import com.nicenetwork.model.User;
import com.nicenetwork.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by gsp on 12/07/2016.
 */

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @RequestMapping(value = "backend/file/{id}", method = RequestMethod.GET)
    public String index(
            @PathVariable("id") Integer id,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "searchKeyword", defaultValue = "", required = false) String searchKeyword,
            Model model) {

        int countpage = 0;

        countpage = page * 5;

        List<File> param = fileService.getData(countpage, 5, searchKeyword,id);
        model.addAttribute("list_data", param);

        System.out.println("sout file ="+param);

        for (File u:param){
            System.out.println("sout file ="+u.toString());
        }

        model.addAttribute("startpage", page / 5);

        if (fileService.getCount(searchKeyword,id) % 5 == 0)
        {
            model.addAttribute("endpage", (fileService.getCount(searchKeyword,id)/5) - 1);
        }
        else
        {
            model.addAttribute("endpage", fileService.getCount(searchKeyword,id)/5);
        }

        model.addAttribute("href", "?searchKeyword=" + searchKeyword + "&page=");

        return "landing_page.file.template";
    }

    @RequestMapping(value = "backend/file/insert", method = RequestMethod.POST)
    public String inserting(
            RedirectAttributes attr,
            @ModelAttribute File file,
            @RequestParam(value = "attachment", defaultValue = "") MultipartFile Attachment,
            @RequestParam(value = "id", defaultValue = "") int id
    ) {

        System.out.println("file.getParent_id() from ctrl = " + id);

        if (Attachment.getSize() > 1000000) {
            attr.addFlashAttribute("Message", "File To Large");
            return "redirect:/backend/file/" + id;
        } else {
            try {

                String filename = Attachment.getOriginalFilename();
                try {

                    java.io.File theDir = new java.io.File("/" + "nicenetwork_file" + "/" + id );
                    theDir.mkdir();

                    byte[] bytes = Attachment.getBytes();
                    BufferedOutputStream buffStream =
                            new BufferedOutputStream(new FileOutputStream(new java.io.File("/" + "nicenetwork_file" + "/" + id +"/"+ file.getName()+filename)));
                    buffStream.write(bytes);
                    buffStream.close();

                } catch (Exception e) {
                    attr.addFlashAttribute("Message", e.getCause().getMessage());
                    return "redirect:/backend/file/" + id;
                }
                file.setFile(file.getName()+filename);
                file.setParent_id(id);
                fileService.save(file);
                attr.addFlashAttribute("Message", "Data Saved");
            } catch (Exception ex) {
                ex.getMessage();
                attr.addFlashAttribute("Message", ex.getCause().getMessage());
            }
        }


        return "redirect:/backend/file/" + id;
    }

    @RequestMapping(value = "backend/file/delete/{file_id}", method = RequestMethod.GET)
    public String deleting(
            @PathVariable("file_id") int file_id,
            HttpServletRequest request,
            RedirectAttributes attr) {
        try {
            File param = fileService.getDataById(file_id);
            java.io.File file = new java.io.File("/" + "nicenetwork_file" + "/" + param.getParent_id() +"/"+ param.getFile());
            file.delete();
            fileService.delete(file_id);
            attr.addFlashAttribute("Message", "Data has been delete");
        } catch (Exception ex) {
            ex.getMessage();
            attr.addFlashAttribute("Message", ex.getCause().getMessage());
        }
        return "redirect:" + request.getHeader("Referer");
    }

}
