package com.sysmap.redesocial.post.service.dto;

public record CreatePostRequestDTO(
        String userId,
        String postContent,
        String uriPostImage

        ) {

}
