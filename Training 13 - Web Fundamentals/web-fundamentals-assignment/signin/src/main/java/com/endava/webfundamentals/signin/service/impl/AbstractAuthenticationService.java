package com.endava.webfundamentals.signin.service.impl;

import com.endava.webfundamentals.signin.dto.UserCredentialDTO;
import com.endava.webfundamentals.signin.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Created by fstancu on 7/22/2016.
 */

public abstract class AbstractAuthenticationService implements AuthenticationService {

    protected static final String SESSION = "session";

    @Value("#{'${users}'.split(',')}")
    protected List<String> users;

    @Value("${password:password}")
    private String password;

    @Override
    public boolean isValid(UserCredentialDTO userCredentialDTO) {
        return userCredentialDTO != null && users.contains(userCredentialDTO.getUsername().toLowerCase()) &&
                password.equals(userCredentialDTO.getPassword());
    }

}
