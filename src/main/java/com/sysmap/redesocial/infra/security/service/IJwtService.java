package com.sysmap.redesocial.infra.security.service;

import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface IJwtService {
    String generateToken(UUID userId);
    boolean isValidToken(String token, UUID userId);
}
