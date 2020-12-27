package com.twitter.like;

import com.twitter.tweetaction.TweetAction;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Like extends TweetAction {
    public Like() {}
}
