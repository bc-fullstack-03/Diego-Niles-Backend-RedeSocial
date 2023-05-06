package com.sysmap.redesocial.like.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Like implements Serializable {

    private UUID userId;

    @Override
    public String toString() {
        return "Like{" +
                "userId=" + userId +
                '}';
    }
}
