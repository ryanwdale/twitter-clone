package com.twitter.follow;

import com.twitter.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFollowed(User followed);

    List<Follow> findByFollower(User follower);

    void deleteByFollowedAndFollower(User followed, User follower);
}
