package com.example.twitter.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("could not find user with ID: " + userId);
    }
}