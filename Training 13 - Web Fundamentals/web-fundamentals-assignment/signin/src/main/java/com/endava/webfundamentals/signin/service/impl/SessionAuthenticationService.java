package com.endava.webfundamentals.signin.service.impl;

import com.endava.webfundamentals.signin.dto.UserCredentialDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by fstancu on 7/25/2016.
 */

@Service("sessionAuthenticationService")
public class SessionAuthenticationService extends AbstractAuthenticationService {

    @Override
    public boolean login(UserCredentialDTO userCredentialDTO, HttpServletRequest request, HttpServletResponse response) {
        if (isValid(userCredentialDTO)) {
            HttpSession session = request.getSession();
            session.setAttribute(SESSION, userCredentialDTO.getUsername());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isLogged(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object token = session.getAttribute(SESSION);
        return token != null && users.contains(token.toString());
    }

    @Override
    public String getLoggedUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object token = session.getAttribute(SESSION);
        if (token != null) {
            return token.toString();
        } else {
            return null;
        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(SESSION);
    }

}
