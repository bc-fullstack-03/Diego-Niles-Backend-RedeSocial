package com.sysmap.redesocial.infra.security.service;

import java.util.UUID;

public interface IJwtService {
    String generateToken(UUID userId);

    boolean isValidToken(String token, String userId);
}
