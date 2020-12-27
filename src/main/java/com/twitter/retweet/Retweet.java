package com.example.twitter.retweet;

import com.example.twitter.tweetaction.TweetAction;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Retweet extends TweetAction {
    public Retweet() {}
}
