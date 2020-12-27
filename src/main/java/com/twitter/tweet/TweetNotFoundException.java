package com.twitter.tweet;

public class TweetNotFoundException extends RuntimeException {
    public TweetNotFoundException(Long tweetId) {
        super("could not find tweet with ID: " + tweetId);
    }
}
