package com.sysmap.redesocial.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public record CreateUserDTO(
        String name
) {

}
