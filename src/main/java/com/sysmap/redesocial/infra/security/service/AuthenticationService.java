package com.sysmap.redesocial.infra.security.service;

import com.sysmap.redesocial.user.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    private UserService userService;

    @Autowired
    private IJwtService _JwtService;

    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest request) {

        var user = userService.getUser(request.email);

        if (user == null) {
            return null;
        }

        if (!user.getPassword().equals(request.password)) {
            return null;
        }

        var token = _JwtService.generateToken(user.getUserId());

        var response = new AuthenticateResponse();

        response.setUserId(user.getUserId());
        response.setToken(token);

        return response;
    }
}
