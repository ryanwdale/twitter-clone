package com.example.twitter.like;

import com.example.twitter.like.Like;
import com.example.twitter.tweetaction.TweetActionRepository;
import com.example.twitter.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends TweetActionRepository<Like> {

}
