package com.twitter.retweet;

import com.twitter.tweetaction.TweetAction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Retweet extends TweetAction {

}
