package com.sysmap.redesocial.user.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


public record CreateUserRequestDTO(
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
