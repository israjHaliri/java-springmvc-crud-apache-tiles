package com.nicenetwork.controller.frontend;

import com.nicenetwork.model.User;
import com.nicenetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

/**
 * Created by gsp on 12/07/2016.
 */

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        File theDir = new File("/" + "nicenetwork_file");

        if (!theDir.exists()) {
            try {
                theDir.mkdir();
            } catch (SecurityException se) {
                System.out.println("cannot create directory");
            }
        }

        model.addAttribute("list_data", "Welcome");

        return "home.template";
    }
}
