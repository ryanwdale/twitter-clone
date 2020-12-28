package com.twitter.tweetaction;

import com.twitter.tweet.Tweet;
import com.twitter.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TweetActionRepository<T extends TweetAction> extends JpaRepository<T, Long> {
    List<T> findByUser(User user);
    List<T> findByTweet(Tweet tweet);
}
