package com.sysmap.redesocial.infra.security.service;

import com.sysmap.redesocial.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    private UserService userService;

    @Autowired
    private IJwtService _JwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest request) {

        var user = userService.getUser(request.email);


        if (user == null) {
            return null;
        }

        if (!passwordEncoder.matches(request.password, user.getPassword())) {
            return null;
        }

        var token = _JwtService.generateToken(user.getUserId());

        var response = new AuthenticateResponse();

        response.setUserId(user.getUserId());
        response.setToken(token);

        return response;
    }
}
