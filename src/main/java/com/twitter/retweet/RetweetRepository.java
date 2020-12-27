package com.twitter.retweet;

import com.twitter.tweetaction.TweetActionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetweetRepository extends TweetActionRepository<Retweet> {
}
