package com.example.twitter.tweetaction;

import com.example.twitter.tweet.Tweet;
import com.example.twitter.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Inheritance
public abstract class TweetAction {
    @Id
    @GeneratedValue
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "tweetId")
    private Tweet tweet;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
