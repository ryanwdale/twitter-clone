package com.twitter.user;

import com.twitter.follow.Follow;
import com.twitter.reply.Reply;
import com.twitter.tweet.Tweet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String userName;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Tweet> tweets = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private List<Follow> followers = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "followed", cascade = CascadeType.ALL)
    private List<Follow> follows = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public User() {}

    public void addFollow(Follow follow) {
        follows.add(follow);
    }

    public void addFollower(Follow follow) {
        followers.add(follow);
    }

    public void tweet(Tweet tweet) {
        tweets.add(tweet);
    }

}
