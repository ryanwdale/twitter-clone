package com.example.twitter.tweet;

import com.example.twitter.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @CreationTimestamp
    private LocalDateTime createdAt;


    public Tweet(String content, User user) {
        this.content = content;
        this.user = user;
    }

    public Tweet() {}

}
