package com.example.twitter.tweet;

import com.example.twitter.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    @Query(value = "SELECT * FROM tweet JOIN user ON tweet.user_id = user.id " +
            "JOIN follow ON follow.followed_id = user.id " +
            "WHERE follow.follower_id = ?1", nativeQuery = true)
    List<Tweet> findTimeline(Long userId);

    List<Tweet> findByUser(User user);
}
