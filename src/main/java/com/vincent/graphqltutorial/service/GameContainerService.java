package com.vincent.graphqltutorial.service;

import com.vincent.graphqltutorial.entity.GameContainer;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

public class GameContainerService {
    List<GameContainer> gameContainer;

    @PostConstruct
    public void init(){
        gameContainer = Arrays.asList(new GameContainer(1617L, "PML Riichi Mahjong Open 2022"));
    }
}
