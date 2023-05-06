package com.sysmap.redesocial.post.service.dto;

import com.sysmap.redesocial.comments.domain.Comments;
import com.sysmap.redesocial.like.domain.Like;
import com.sysmap.redesocial.post.domain.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record SearchPostDTO(
        UUID postId,
        String postContent,
        String uriPostImage,
        LocalDateTime postDate,
        List<Like> postLike,
        List<Comments> comment

) {
    public SearchPostDTO(Post post) {
        this(post.getPostId(), post.getPostContent(), post.getUriPostImage(), post.getPostDate(), post.getPostLike(), post.getComment());
    }
}
