package com.twitter.reply;

import com.twitter.tweet.Tweet;
import com.twitter.tweetaction.TweetAction;
import com.twitter.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Reply extends TweetAction {
    private String content;

    public Reply(User user, Tweet tweet, String content) {
        super(user, tweet);
        this.content = content;
    }

    public Reply() {}
}
