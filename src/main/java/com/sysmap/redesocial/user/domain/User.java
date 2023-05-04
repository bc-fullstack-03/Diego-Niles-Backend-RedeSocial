package com.sysmap.redesocial.user.domain;

import com.sysmap.redesocial.post.domain.Post;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collation = "user")
public class User {
    @Id
    private UUID userId;
    private String userName;
    private String email;
    private String password;

    List<User> friends;
    List<Post> post;

    public User() {
    }

    public User(String userName, String email, String password) {
        this.userId = UUID.randomUUID();
        this.userName = userName;
        this.email = email;
        this.password = password;
        friends = new ArrayList<>();
        post = new ArrayList<>();
    }

    public User(UUID userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }
}
