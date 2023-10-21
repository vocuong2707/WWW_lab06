package com.example.vocuong_lab06.Users;

import com.example.vocuong_lab06.Post.Post;
import com.example.vocuong_lab06.PostComment.PostComment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "mobile" , nullable = false , length = 50)
    private String mobile;
    @Column(name = "last_login" , nullable = false)
    private Instant lastLogin;
    @Column(name = "last_name" , nullable = false , length =  150)
    private Instant lastName;
    @Column(name = "intro" , length = 150)
    private String intro;
    @Column(name = "profile" , nullable = false , length = 150)
    private String profile;
    @Column(name = "registered_at" , nullable = false)
    private Instant registeredAt;
    @OneToMany(mappedBy = "user")
    private Set<PostComment> postComments;
    @Column(name = "password_hash" , nullable = false , length = 150)
    private String passwordHash;
    @Column(name = "middle_name" , nullable = true , length = 150)
    private String middleName;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;
    @Column(name = "first_name" , nullable = false , length = 150)
    private String firstName;
    @Column(name = "email" , nullable = false , length = 150)
    private String email;
}
