package com.sysmap.redesocial.user.domain;

import java.util.List;
import java.util.UUID;

public record FindUserDTO(
        UUID userId,
        String userName,
        String email,
        String uriProfilePhoto,
        List<User> friends
) {
    public FindUserDTO(User user) {
        this(user.getUserId(), user.getUserName(), user.getEmail(), user.getUriProfilePhoto(), user.getFriends());
    }
}
