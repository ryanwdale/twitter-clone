package com.twitter;

import com.twitter.reply.Reply;
import com.twitter.reply.ReplyRepository;
import com.twitter.tweet.Tweet;
import com.twitter.tweet.TweetRepository;
import com.twitter.follow.Follow;
import com.twitter.follow.FollowRepository;
import com.twitter.tweetaction.TweetActionRepository;
import com.twitter.user.User;
import com.twitter.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   TweetRepository tweetRepository,
                                   FollowRepository followRepository,
                                   ReplyRepository replyRepository) {

        replyRepository.deleteAll();
        followRepository.deleteAll();
        tweetRepository.deleteAll();
        userRepository.deleteAll();
        User john = new User("John Doe");
        User fred = new User("Fred Smith");

        Tweet tweet1 = new Tweet("cool tweet", john);
        Tweet tweet2 = new Tweet("very cool tweet", fred);
        Tweet tweet3 = new Tweet("another cool tweet", fred);
        john.tweet(tweet1);
        fred.tweet(tweet2);
        fred.tweet(tweet3);

        Follow follow = new Follow(john, fred);
        john.addFollow(follow);
        fred.addFollower(follow);

        Reply reply = new Reply(john, tweet2, "nice");
        john.reply(reply);

        return args -> {
            log.info("Preloading " + userRepository.save(john));
            log.info("Preloading " + userRepository.save(fred));
        };
    }
}
