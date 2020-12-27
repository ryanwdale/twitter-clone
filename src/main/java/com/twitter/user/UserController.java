package com.example.twitter.user;

import com.example.twitter.tweet.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @PostMapping("users/")
    public User addUser(@RequestBody User user) {
        if (userRepository.findById(user.getId()).isPresent())
            return null;
        return userRepository.save(user);
    }

    @PutMapping("users/{userId}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUserName(newUser.getUserName());
                    user.setTweets(newUser.getTweets());
                    user.setFollows(newUser.getFollows());
                    user.setFollowers(newUser.getFollows());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(userId);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }

}
