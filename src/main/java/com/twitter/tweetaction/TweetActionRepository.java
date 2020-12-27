package com.twitter.tweetaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TweetActionRepository<T extends TweetAction> extends JpaRepository<T, Long> {

}
