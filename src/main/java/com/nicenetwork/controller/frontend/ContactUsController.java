package com.nicenetwork.controller.frontend;

import com.nicenetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by gsp on 12/07/2016.
 */

@Controller
public class ContactUsController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/contact_us", method = RequestMethod.GET)
    public String loginPage() {
        return "contactus.template";
    }

    @RequestMapping(value = "/send_message", method = RequestMethod.POST)
    public String auth(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "subject", defaultValue = "") String subject,
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "message", defaultValue = "") String messageToSend,
            Model model
    ) {


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("unicecompany@gmail.com","yourmailapppassword");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("israj.haliri@gmail.com"));
            message.setSubject(subject);
            message.setText(messageToSend);

            Transport.send(message);

            model.addAttribute("message", "Failed to send mail");
            return "contact_us";

        } catch (MessagingException e) {
            e.getCause();
            model.addAttribute("message", "Failed to send mail");
            return "contact_us";
        }
    }
}
