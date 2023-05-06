package com.sysmap.redesocial.user.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record CreateUserDTO(
        @NotNull
        String userName,
        @NotNull
        @Email
        String email,
        @NotNull
        String password,
        String uriProfilePhoto
) {

}
