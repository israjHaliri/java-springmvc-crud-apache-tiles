package com.nicenetwork.controller.frontend;

import com.nicenetwork.service.UserService;
import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by gsp on 12/07/2016.
 */

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String index() {
        return "sign_up.template";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String submitForm(RedirectAttributes attr, ServletRequest request) {

        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("youtcapcthcakey");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (reCaptchaResponse.isValid()) {
            System.out.print("Answer was entered correctly!");
            attr.addFlashAttribute("invalidRecaptcha",false);
        } else {
            System.out.print("Answer is wrong");
            attr.addFlashAttribute("invalidRecaptcha", true);
        }

        return "redirect:/sign_up";
    }
}
