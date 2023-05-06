package com.sysmap.redesocial.comments.domain;

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
public class Comments implements Serializable {

    private UUID userId;
    private String commentContent;
    ;

    @Override
    public String toString() {
        return "Comments{" +
                "userId=" + userId +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}


