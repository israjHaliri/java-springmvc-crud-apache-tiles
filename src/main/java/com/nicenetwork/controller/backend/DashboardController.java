package com.nicenetwork.controller.backend;

import com.nicenetwork.model.User;
import com.nicenetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.security.Principal;
import java.util.Enumeration;

/**
 * Created by gsp on 12/07/2016.
 */

@Controller
public class DashboardController {

    @RequestMapping(value = "backend/dashboard", method = RequestMethod.GET)
    public String index() {
        return "dashboard.template";
    }
}
