package com.example.twitter.tweetaction;

import com.example.twitter.tweetaction.TweetAction;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Like extends TweetAction {
    public Like() {}
}
