package com.twitter.tweet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.twitter.reply.Reply;
import com.twitter.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Tweet {

    @GeneratedValue
    @Id
    private Long id;

    private String content;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @JsonBackReference
    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;


    public Tweet(String content, User user) {
        this.content = content;
        this.user = user;
    }

    public Tweet() {}

}
