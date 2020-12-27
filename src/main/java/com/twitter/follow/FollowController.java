package com.twitter.follow;

import com.twitter.tweet.TweetRepository;
import com.twitter.user.User;
import com.twitter.user.UserNotFoundException;
import com.twitter.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private FollowRepository followRepository;

    @PostMapping("/follows")
    public void follow(@RequestParam Long followerId, @RequestParam Long followingId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new UserNotFoundException(followerId));
        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new UserNotFoundException(followingId));
        Follow follow = new Follow(follower, following);
        followRepository.save(follow);
    }

    @DeleteMapping("/follows")
    public void deleteFollow(@RequestParam Long followerId, @RequestParam Long followingId) {
        User followed = userRepository.findById(followerId).orElseThrow(() -> new UserNotFoundException(followerId));
        User follower = userRepository.findById(followingId).orElseThrow(() -> new UserNotFoundException(followingId));
        followRepository.deleteByFollowedAndFollower(followed, follower);
    }

    @GetMapping("/follows/{followId}")
    public Follow getFollow(@PathVariable Long followId) {
        return followRepository.findById(followId).orElseThrow(() -> new FollowNotFoundException(followId));
    }

    @GetMapping("/follows")
    public List<Follow> getFollows() {
        return followRepository.findAll();
    }

    @GetMapping("/user/{userId}/follows")
    public List<User> getUserFollows(@PathVariable Long userId) {
        return userRepository.findFollows(userId);
    }

    @GetMapping("/user/{userId}/followers")
    public List<User> getUserFollowers(@PathVariable Long userId) {
        return userRepository.findFollowers(userId);
    }

}
