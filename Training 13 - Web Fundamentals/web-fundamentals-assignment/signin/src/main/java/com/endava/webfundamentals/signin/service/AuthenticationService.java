package com.endava.webfundamentals.signin.service;

import com.endava.webfundamentals.signin.dto.UserCredentialDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fstancu on 7/22/2016.
 */

public interface AuthenticationService {

    boolean isValid(UserCredentialDTO userCredentialDTO);

    boolean login(UserCredentialDTO userCredentialDTO, HttpServletRequest request, HttpServletResponse response);

    boolean isLogged(HttpServletRequest request);

    String getLoggedUser(HttpServletRequest request);

    void logout(HttpServletRequest request, HttpServletResponse response);

}
