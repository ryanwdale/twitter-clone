package com.twitter.retweet;

import com.twitter.tweet.Tweet;
import com.twitter.tweet.TweetNotFoundException;
import com.twitter.tweet.TweetRepository;
import com.twitter.user.User;
import com.twitter.user.UserNotFoundException;
import com.twitter.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RetweetController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private RetweetRepository retweetRepository;

    @GetMapping("/retweets")
    public List<Retweet> getRetweets() {
        return retweetRepository.findAll();
    }

    @GetMapping("/retweets/{retweetId}")
    public Retweet getRetweet(@PathVariable Long retweetId) {
        return retweetRepository.findById(retweetId).orElseThrow(() -> new RetweetNotFoundException(retweetId));
    }

    @GetMapping("/users/{userId}/retweets")
    public List<Retweet> getUserRetweets(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return retweetRepository.findByUser(user);
    }

    @GetMapping("/tweets/{tweetId}/retweets")
    public List<Retweet> getTweetReplies(@PathVariable Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
        return retweetRepository.findByTweet(tweet);
    }

    @GetMapping("/tweets/{tweetId}/retweets/users/{userId}")
    public List<Retweet> getUserRetweetsOnTweet(@PathVariable Long userId, @PathVariable Long tweetId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
        return retweetRepository.findByTweetAndUser(tweet, user);
    }

    @PostMapping("/tweets/{tweetId}/retweets/users/{userId}")
    public Retweet addRetweet(@PathVariable Long tweetId, @PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
        Retweet retweet = new Retweet(user, tweet);
        return retweetRepository.save(retweet);
    }

    @DeleteMapping("/retweets/{retweetId}")
    public void deleteTweet(@PathVariable Long retweetId) {
        retweetRepository.deleteById(retweetId);
    }

}
