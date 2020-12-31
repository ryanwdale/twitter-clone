package com.twitter.retweet;

import com.twitter.tweet.Tweet;
import com.twitter.tweetaction.TweetAction;
import com.twitter.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Retweet extends TweetAction {
    public Retweet(User user, Tweet tweet) {
        super(user, tweet);
    }

    public Retweet() {}
}
