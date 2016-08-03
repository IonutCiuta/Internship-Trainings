package com.endava.webfundamentals.signin.controller;

import com.endava.webfundamentals.signin.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;

/**
 * Created by fstancu on 7/25/2016.
 */

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Resource(name = "${spring.bean.authentication}")
    private AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (authenticationService.isLogged(request)) {
            String loggedUser = authenticationService.getLoggedUser(request);
            model.addAttribute("user", loggedUser);
            return "dashboard";
        } else {
            model.addAttribute("message", "Please login first!");
            response.setStatus(SC_FORBIDDEN);
            return "login";
        }
    }

}
