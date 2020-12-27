package com.twitter.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user" +
            "JOIN follow ON follow.followed_id = user.id " +
            "WHERE follow.follower_id = ?1", nativeQuery = true)
    List<User> findFollows(Long userId);

    @Query(value = "SELECT * FROM user" +
            "JOIN follow ON follow.follower_id = user.id " +
            "WHERE follow.followed_id = ?1", nativeQuery = true)
    List<User> findFollowers(Long userId);
}
