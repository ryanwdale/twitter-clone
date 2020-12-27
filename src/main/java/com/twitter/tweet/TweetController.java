package com.twitter.tweet;

import com.twitter.user.User;
import com.twitter.user.UserNotFoundException;
import com.twitter.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TweetController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/tweets")
    public List<Tweet> getTweets() {
        return tweetRepository.findAll();
    }

    @GetMapping("/tweets/{tweetId}")
    public Tweet getTweet(@PathVariable Long tweetId) {
        return tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
    }

    @GetMapping("/users/{userId}/tweets")
    public List<Tweet> getUserTweets(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return tweetRepository.findByUser(user);
    }

    @GetMapping("/users/{userId}/timeline")
    public List<Tweet> getTimeline(@PathVariable Long userId) {
        return tweetRepository.findTimeline(userId);
    }

    @PostMapping("/user/{userId}/tweets/")
    public Tweet addTweet(@RequestParam String content, @PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Tweet tweet = new Tweet(content, user);
        return tweetRepository.save(tweet);
    }

    @DeleteMapping("/tweets/{tweetId}")
    public void addTweet(@PathVariable Long tweetId) {
        tweetRepository.deleteById(tweetId);
    }
}
