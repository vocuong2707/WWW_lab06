package com.example.vocuong_lab06.Post;

import com.example.vocuong_lab06.PostComment.PostComment;
import com.example.vocuong_lab06.Users.User;
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
@Table(name = "Post")
public class Post {
    @Id
    private long id;
    @Column(name = "published" , nullable = false)
    private boolean published;
    @Column(name = "content" , nullable = true , length = 150)
    private String content;


    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Post parent;
    @Column(name = "meta_title" , nullable = true , length = 150)
    private String metaTitle;
    @Column(name = "summary")
    private String summary;
    @Column(name = "create_at" , nullable = false)
    private Instant createAt;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts;

    @Column(name = "title" , nullable = false , length = 150)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;
    @Column(name = "update_at" , nullable = true)
    private Instant updatedAt;
    @Column(name = "published_at" , nullable = true)
    private Instant publishedAt;

}
