package com.sysmap.redesocial.user.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "userId")
@Document(collection = "user")
public class User implements Serializable {
    @Id
    private UUID userId;
    private String userName;
    private String email;
    private String password;
    private String uriProfilePhoto;
    List<User> friends;


    public User(String userName, String email, String password, String uriProfilePhoto) {
        this.userId = UUID.randomUUID();
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.uriProfilePhoto = uriProfilePhoto;
        this.friends = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", uriProfilePhoto='" + uriProfilePhoto + '\'' +
                ", friends=" + friends +
                '}';
    }
}
