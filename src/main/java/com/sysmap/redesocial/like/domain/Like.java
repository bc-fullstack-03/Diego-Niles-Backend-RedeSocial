package com.sysmap.redesocial.like.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Like {

    private UUID likeId;
    private LocalDateTime likeDate;

    public Like(LocalDateTime likeDate) {
        this.likeId = UUID.randomUUID();
        this.likeDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeId=" + likeId +
                ", likeDate=" + likeDate +
                '}';
    }
}
