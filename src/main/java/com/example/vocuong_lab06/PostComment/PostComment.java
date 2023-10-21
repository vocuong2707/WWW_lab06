package com.example.vocuong_lab06.PostComment;


import com.example.vocuong_lab06.Post.Post;
import com.example.vocuong_lab06.Users.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_comment")
@Getter
@Setter
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @Column(name = "title" , nullable = false , length = 100)
    private String title;

    @Column(name = "published" , nullable = false)
    private Boolean published;

    @Column(name = "content" , nullable = true)
    private String content;
    @Column(name = "published_At" , nullable = false)
    private Instant publishedAt;
    @Column(name = "create_at" , nullable = false)
    private Instant createAt;





//    ========
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private PostComment parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;




}
