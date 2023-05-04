package com.sysmap.redesocial.post.domain;

import com.sysmap.redesocial.like.domain.Like;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post implements Serializable {

    private UUID postId;
    private String postContent;
    private LocalDateTime postDate;
    private List<Like> postLike;

    public Post(String content, LocalDateTime postDate) {
        this.postId = UUID.randomUUID();
        this.postContent = content;
        this.postDate = postDate;
        this.postLike = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postContent='" + postContent + '\'' +
                ", postDate=" + postDate +
                ", postLike=" + postLike +
                '}';
    }
}
