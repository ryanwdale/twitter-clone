package com.twitter.reply;

public class ReplyNotFoundException extends RuntimeException {
    public ReplyNotFoundException(Long replyId) {
        super("could not find reply with ID: " + replyId);
    }
}