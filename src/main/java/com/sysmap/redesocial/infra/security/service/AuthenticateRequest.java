package com.sysmap.redesocial.infra.security.service;

import lombok.Data;

@Data
public class AuthenticateRequest {

    public String email;
    public String password;
}
