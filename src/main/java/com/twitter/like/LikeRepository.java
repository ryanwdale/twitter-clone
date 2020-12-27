package com.twitter.like;

import com.twitter.tweetaction.TweetActionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends TweetActionRepository<Like> {

}
