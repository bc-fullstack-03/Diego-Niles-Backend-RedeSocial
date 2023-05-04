package com.sysmap.redesocial.comments.domain;

import com.sysmap.redesocial.like.domain.Like;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Comments implements Serializable {

    private UUID commentId;
    private String commentContent;
    private LocalDateTime commentDate;
    private List<Like> commentLike;

    public Comments(String commentContent, LocalDateTime commentDate) {
        this.commentId = UUID.randomUUID();
        this.commentContent = commentContent;
        this.commentDate = LocalDateTime.now();
        this.commentLike = new ArrayList<>();
    }

    public Comments(UUID commentId, String commentContent, LocalDateTime commentDate, List<Like> commentLike) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentLike = commentLike;
    }
}


