package com.twitter.retweet;

import com.twitter.tweetaction.TweetAction;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Retweet extends TweetAction {
    public Retweet() {}
}
