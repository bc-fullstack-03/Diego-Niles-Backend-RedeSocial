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
    private String name;

    List<User> friends;
    List<Post> post;

    public User() {
    }

    public User(String name) {
        this.userId = UUID.randomUUID();
        this.name = name;
        friends = new ArrayList<>();
        post = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", friends=" + friends +
                ", post=" + post +
                '}';
    }
}
