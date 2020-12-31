package com.twitter.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twitter.follow.Follow;
import com.twitter.reply.Reply;
import com.twitter.tweet.Tweet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    public enum Role {USER, ADMIN};

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String userName;

    @NotNull
    @JsonIgnore
    @ToString.Exclude
    private String password;

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

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
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

    public void reply(Reply reply) {
        replies.add(reply);
    }

}
