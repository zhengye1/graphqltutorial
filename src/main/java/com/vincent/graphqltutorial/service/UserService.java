package com.vincent.graphqltutorial.service;

import com.vincent.graphqltutorial.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    List<User> users;

    @PostConstruct
    public void init() {
        users = Arrays.asList(new User(517L, "Yuqi"), new User(500L, "Emily500"), new User(590L, "Vincent"),
            new User(594L, "Kelvin594"));
    }

    public User findById(Long userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
    }
}
