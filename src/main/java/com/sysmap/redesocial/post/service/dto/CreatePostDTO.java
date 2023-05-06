package com.sysmap.redesocial.post.service.dto;

import com.sysmap.redesocial.like.domain.Like;

import java.time.LocalDateTime;
import java.util.List;

public record CreatePostDTO(
        String postContent,
        String uriPostImage

        ) {

}
