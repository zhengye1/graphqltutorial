package com.vincent.graphqltutorial.service;

import com.vincent.graphqltutorial.entity.Player;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

import static com.vincent.graphqltutorial.enumeration.Direction.*;

@Service
public class PlayerService {
    List<Player> players;

    @PostConstruct
    public void init() {
        players = Arrays.asList(new Player(18326L, 500L, 8779, SOUTH), new Player(18327L, 517L, 8779, WEST),
            new Player(18328L, 590L, 8779, NORTH), new Player(18329L, 594L, 8779, EAST));
    }

    public List<Player> findAllPlayers() {
        return this.players;
    }

    public Player getById(Long id) {
        return this.players.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }


}
