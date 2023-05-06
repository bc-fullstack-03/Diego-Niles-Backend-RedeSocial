package com.sysmap.redesocial.post.domain;

import com.sysmap.redesocial.comments.domain.Comments;
import com.sysmap.redesocial.like.domain.Like;
import com.sysmap.redesocial.post.service.dto.CreatePostDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"postId"})
@Document(collection = "post")

public class Post implements Serializable {
    @Id
    private UUID postId;
    private UUID userId;
    private String postContent;
    private String uriPostImage;
    private LocalDateTime postDate;
    private List<Like> postLike;
    private List<Comments> comment;

    public Post(CreatePostDTO postDTO) {
        this.postId = UUID.randomUUID();
        this.postContent = postDTO.postContent();
        this.uriPostImage = postDTO.uriPostImage();
        this.postDate = LocalDateTime.now();
        this.postLike = new ArrayList<>();
        this.comment = new ArrayList<>();
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
