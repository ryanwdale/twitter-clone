package com.example.twitter.retweet;

import com.example.twitter.retweet.Retweet;
import com.example.twitter.tweetaction.TweetActionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetweetRepository extends TweetActionRepository<Retweet> {
}
