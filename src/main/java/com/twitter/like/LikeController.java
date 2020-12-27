package com.example.twitter.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LikeController {

    @Autowired
    LikeRepository likeRepository;

    @GetMapping("/likes")
    List<Like> getLikes() {
        return likeRepository.findAll();
    }

//    @GetMapping("/user/{userId}/likes")
//    List<Like> getUsersLikes(@PathVariable Long userId) {
//        return likeRepository.();
//    }

}
