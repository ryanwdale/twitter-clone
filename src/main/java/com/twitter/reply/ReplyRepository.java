package com.example.twitter.reply;

import com.example.twitter.reply.Reply;
import com.example.twitter.tweetaction.TweetActionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends TweetActionRepository<Reply> {
}
