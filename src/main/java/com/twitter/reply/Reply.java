package com.example.twitter.reply;

import com.example.twitter.tweetaction.TweetAction;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Reply extends TweetAction {

    private String content;

    public Reply() {}
}
