package com.twitter.follow;

import com.twitter.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Follow {

    @Id
    @GeneratedValue
    private Long id;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "followerId")
    private User follower;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "followedId")
    private User followed;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Follow(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
    }
    public Follow() {}
}
