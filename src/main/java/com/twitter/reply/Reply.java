package com.twitter.reply;

import com.twitter.tweetaction.TweetAction;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Reply extends TweetAction {

    private String content;

    public Reply() {}
}
