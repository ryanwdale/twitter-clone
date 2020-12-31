package com.twitter.like;

import com.twitter.tweet.Tweet;
import com.twitter.tweetaction.TweetAction;
import com.twitter.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Like extends TweetAction {
    public Like(User user, Tweet tweet) {
        super(user, tweet);
    }

    public Like() {}
}
