package com.nicenetwork.controller.frontend;

import com.nicenetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by gsp on 29/07/2016.
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException,
            ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        com.nicenetwork.model.User param = userService.getDataByName(name);

        HttpSession session = request.getSession();
        session.setAttribute("photo", param.getProfile().getPhoto());
        session.setAttribute("email", param.getProfile().getEmail());
        session.setAttribute("name", param.getProfile().getUser_name());

        response.sendRedirect("/backend/dashboard");

    }


}
