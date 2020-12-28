package com.twitter.like;

import com.twitter.tweetaction.TweetAction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Like extends TweetAction {

}
