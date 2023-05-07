package com.sysmap.redesocial.infra.security.service;

import org.springframework.stereotype.Repository;


public interface IAuthenticationService {

    AuthenticateResponse authenticate(AuthenticateRequest request);
}
