package com.sysmap.redesocial.user.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public record CreateUserDTO(
        String userName,
        String email,
        String password,
        String uriProfilePhoto
) {

}
