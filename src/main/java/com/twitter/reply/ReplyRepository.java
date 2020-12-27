package com.twitter.reply;

import com.twitter.tweetaction.TweetActionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends TweetActionRepository<Reply> {
}
