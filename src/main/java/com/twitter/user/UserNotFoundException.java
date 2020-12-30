package com.twitter.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("could not find user with ID: " + userId);
    }
    public UserNotFoundException(String userName) {
        super("could not find user with user name: " + userName);
    }
}