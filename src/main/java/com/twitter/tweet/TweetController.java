package com.twitter.tweet;

import com.twitter.tweet.Tweet;
import com.twitter.tweet.TweetNotFoundException;
import com.twitter.tweet.TweetRepository;
import com.twitter.tweet.TweetRequest;
import com.twitter.user.User;
import com.twitter.user.UserNotFoundException;
import com.twitter.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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

    @PostMapping("/users/{userId}/tweets")
    public Tweet addTweet(@RequestBody TweetRequest tweetRequest, @PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Tweet tweet = new Tweet(tweetRequest.getContent(), user);
        return tweetRepository.save(tweet);
    }

    @DeleteMapping("/tweets/{tweetId}")
    public void deleteTweet(@PathVariable Long tweetId) {
        tweetRepository.deleteById(tweetId);
    }
}
