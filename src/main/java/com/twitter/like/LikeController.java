package com.twitter.like;

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
public class LikeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private LikeRepository likeRepository;

    @GetMapping("/likes")
    public List<Like> getLikes() {
        return likeRepository.findAll();
    }

    @GetMapping("/likes/{likeId}")
    public Like getLike(@PathVariable Long likeId) {
        return likeRepository.findById(likeId).orElseThrow(() -> new LikeNotFoundException(likeId));
    }

    @GetMapping("/users/{userId}/likes")
    public List<Like> getUserReplies(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return likeRepository.findByUser(user);
    }

    @GetMapping("/tweets/{tweetId}/likes")
    public List<Like> getTweetReplies(@PathVariable Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
        return likeRepository.findByTweet(tweet);
    }

    @GetMapping("/tweets/{tweetId}/likes/users/{userId}")
    public List<Like> getUserLikesOnTweet(@PathVariable Long userId, @PathVariable Long tweetId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
        return likeRepository.findByTweetAndUser(tweet, user);
    }

    @PostMapping("/tweets/{tweetId}/likes/users/{userId}")
    public Like addLike(@PathVariable Long tweetId, @PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
        Like like = new Like(user, tweet);
        return likeRepository.save(like);
    }

    @DeleteMapping("/likes/{likeId}")
    public void deleteTweet(@PathVariable Long likeId) {
        likeRepository.deleteById(likeId);
    }

}
