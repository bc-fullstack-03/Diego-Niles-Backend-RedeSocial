package com.sysmap.redesocial.infra.security.service;

import lombok.Data;

import java.util.UUID;
@Data
public class AuthenticateResponse {
    public UUID userId;
    public String token;
}
