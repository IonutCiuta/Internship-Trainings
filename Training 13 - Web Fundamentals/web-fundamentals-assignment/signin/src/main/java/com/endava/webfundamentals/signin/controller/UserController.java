package com.endava.webfundamentals.signin.controller;

import com.endava.webfundamentals.signin.dto.UserCredentialDTO;
import com.endava.webfundamentals.signin.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

/**
 * Created by fstancu on 7/22/2016.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "${spring.bean.authentication}")
    private AuthenticationService authenticationService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Object doLogin(@ModelAttribute UserCredentialDTO userCredentialDTO, Model model,
                          HttpServletRequest request, HttpServletResponse response) {
        if (authenticationService.login(userCredentialDTO, request, response)) {
            return new RedirectView("/dashboard");
        } else {
            model.addAttribute("message", "Wrong user or password!");
            response.setStatus(SC_UNAUTHORIZED);
        }
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response) {
        authenticationService.logout(request, response);
        return new RedirectView("/");
    }

}
