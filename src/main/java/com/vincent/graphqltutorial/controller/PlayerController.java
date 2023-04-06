package com.vincent.graphqltutorial.controller;

import com.vincent.graphqltutorial.entity.Player;
import com.vincent.graphqltutorial.entity.User;
import com.vincent.graphqltutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerController {

    @Autowired
    UserService userService;

    @SchemaMapping
    public User user(Player player){
        return userService.findById(player.getUserId());
    }
}
