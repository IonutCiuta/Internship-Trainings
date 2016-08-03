package com.endava.webfundamentals.signin.service.impl;

import com.endava.webfundamentals.signin.dto.UserCredentialDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fstancu on 7/22/2016.
 */

@Service("cookieAuthenticationService")
public class CookieAuthenticationService extends AbstractAuthenticationService{

    @Override
    public boolean login(UserCredentialDTO userCredentialDTO, HttpServletRequest request, HttpServletResponse response) {
        if (isValid(userCredentialDTO)) {
            Cookie cookie = new Cookie(SESSION, userCredentialDTO.getUsername());
            cookie.setPath("/");
            cookie.setMaxAge(1000); //set expire time to 1000 sec
            response.addCookie(cookie);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isLogged(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (SESSION.equals(cookie.getName())) {
                return users.contains(cookie.getValue());
            }
        }
        return false;
    }

    @Override
    public String getLoggedUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (SESSION.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie(SESSION, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
