package com.vincent.graphqltutorial.controller;

import com.vincent.graphqltutorial.entity.*;
import com.vincent.graphqltutorial.service.GameService;
import com.vincent.graphqltutorial.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.vincent.graphqltutorial.enumeration.HandEventType.*;
import static com.vincent.graphqltutorial.enumeration.Direction.*;
@Controller
@RestController
@RequestMapping("/api/game")
@Slf4j
public class GameController{

    @Autowired
    GameService gameService;

    @Autowired
    PlayerService playerService;


    @PostConstruct
    public void init(){
        log.info("Create game and adding players into games");
        // create a new game
        Game game = gameService.createNewGame(8779);
        // add player to the game
        List<Player> players = playerService.findAllPlayers();
        for (Player p : players){
            gameService.addPlayerToGame(p, game.getId());
        }
        Hand currentHand = new Hand(57105L, 8779, 0,0);
        HandResult currentHandResult = new HandResult();
        currentHandResult.setRiichiLeftover(0);
        currentHandResult.setHonba(0);
        currentHandResult.setNextRepeat(0);
        currentHandResult.setNextRound(1);
        currentHandResult.setRound(0);
        currentHandResult.setRepeat(0);
        currentHandResult.setScoreDelta(new Score(-6000, -3000, 12000, -3000));


        // event
        List<HandEvent> events = new ArrayList<>();
        HandEvent currentEvent = new HandEvent();
        currentEvent.setId(85955L);
        currentEvent.setHandId(57105L);
        currentEvent.setType(Riichi);
        currentEvent.setActor(WEST);
        events.add(currentEvent);
        currentEvent = new HandEvent();
        currentEvent.setId(85956L);
        currentEvent.setHandId(57105L);
        currentEvent.setType(Tsumo);
        currentEvent.setHan(6);
        currentEvent.setFu(30);
        currentEvent.setActor(WEST);
        events.add(currentEvent);

        currentHandResult.setEvents(events);
        gameService.addHandAndHandResultToGame(currentHand, currentHandResult, 8779);
        log.info("Current game state {}",gameService.findAll());


    }

    @GetMapping("/{id}")
    @QueryMapping(name="game")
    public Game findGameById(@PathVariable @Argument Integer id){
        log.info("Finding game with gameId {}", id);
        return gameService.findGameById(id);
    }

    @QueryMapping
    public List<Game> retrieveAllGame(){
        return gameService.findAll();
    }



}
