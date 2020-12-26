package com.example.twitter.tweetaction;

import com.example.twitter.tweetaction.TweetAction;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Retweet extends TweetAction {
    public Retweet() {}
}
