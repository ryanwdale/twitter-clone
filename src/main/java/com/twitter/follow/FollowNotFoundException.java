package com.twitter.follow;

public class FollowNotFoundException extends RuntimeException {
    public FollowNotFoundException(Long followId) {
        super("could not find follow with ID: " + followId);
    }
}
