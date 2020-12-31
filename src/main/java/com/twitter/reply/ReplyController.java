package com.twitter.reply;

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
public class ReplyController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @GetMapping("/replies")
    public List<Reply> getReplies() {
        return replyRepository.findAll();
    }

    @GetMapping("/replies/{replyId}")
    public Reply getReply(@PathVariable Long replyId) {
        return replyRepository.findById(replyId).orElseThrow(() -> new ReplyNotFoundException(replyId));
    }

    @GetMapping("/users/{userId}/replies")
    public List<Reply> getUserReplies(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return replyRepository.findByUser(user);
    }

    @GetMapping("/tweets/{tweetId}/replies")
    public List<Reply> getTweetReplies(@PathVariable Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
        return replyRepository.findByTweet(tweet);
    }

    @GetMapping("/tweets/{tweetId}/replies/users/{userId}")
    public List<Reply> getTweetAndUserReplies(@PathVariable Long userId, @PathVariable Long tweetId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
        return replyRepository.findByTweetAndUser(tweet, user);
    }

    @PostMapping("/tweets/{tweetId}/replies/users/{userId}")
    public Reply addReply(@RequestBody ReplyRequest replyRequest, @PathVariable Long userId, @PathVariable Long tweetId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException(tweetId));
        Reply reply = new Reply(user, tweet, replyRequest.getContent());
        return replyRepository.save(reply);
    }

    @DeleteMapping("/replies/{replyId}")
    public void deleteTweet(@PathVariable Long replyId) {
        replyRepository.deleteById(replyId);
    }
}
