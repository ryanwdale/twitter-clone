package com.example.twitter.tweet;

import com.example.twitter.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
