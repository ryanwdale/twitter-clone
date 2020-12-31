package com.twitter.retweet;

public class RetweetNotFoundException extends RuntimeException {
    public RetweetNotFoundException(Long retweetId) {
        super("could not find retweet with ID: " + retweetId);
    }
}
