package com.example.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/tweets")
    public List<Tweet> getTweets() {
        return tweetRepository.findAll();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/timeline/{userId}")
    public List<Tweet> getTimeline(@PathVariable Long userId) {
        return tweetRepository.findTimeline(userId);
    }

    @PutMapping("/follow")
    public void follow(@RequestParam Long followerId, @RequestParam Long followingId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new UserNotFoundException(followerId));
        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new UserNotFoundException(followingId));

        Follow follow = new Follow(follower, following);
        follower.addFollow(follow);
        following.addFollower(follow);
        userRepository.save(follower);
    }

    @PostMapping("/add/")
    public User addUser(@RequestBody User user) {
        if (userRepository.findById(user.getId()).isPresent())
            return null;
        return userRepository.save(user);
    }

    @PostMapping("/add/tweet/{userId}")
    public Tweet addTweet(@PathVariable Long userId, @RequestParam String tweetContent) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Tweet tweet = new Tweet(tweetContent, user);
        return tweetRepository.save(tweet);
    }
}
