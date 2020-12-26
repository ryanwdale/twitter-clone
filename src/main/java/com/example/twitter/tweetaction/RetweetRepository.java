package com.example.twitter.tweetaction;

import com.example.twitter.tweetaction.Retweet;
import com.example.twitter.tweetaction.TweetActionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetweetRepository extends TweetActionRepository<Retweet> {
}
