package com.sysmap.redesocial.user.service.dto;

import com.sysmap.redesocial.user.domain.User;

import java.util.List;
import java.util.UUID;

public record FindUserResponseDTO(
        UUID userId,
        String userName,
        String email,
        String uriProfilePhoto,
        List<User> friends
) {
    public FindUserResponseDTO(User user) {
        this(user.getUserId(), user.getUserName(), user.getEmail(), user.getUriProfilePhoto(), user.getFriends());
    }
}
