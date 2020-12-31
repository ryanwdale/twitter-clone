package com.twitter.like;

public class LikeNotFoundException extends RuntimeException {
    public LikeNotFoundException(Long likeId) {
        super("could not find like with ID: " + likeId);
    }
}