package com.vincent.graphqltutorial.service;

import com.vincent.graphqltutorial.entity.Game;
import com.vincent.graphqltutorial.entity.Hand;
import com.vincent.graphqltutorial.entity.HandResult;
import com.vincent.graphqltutorial.entity.Player;
import com.vincent.graphqltutorial.enumeration.Status;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GameService {
    List<Game> games;

    @PostConstruct
    public void init() {
        games = new ArrayList<>();
    }

    public Game createNewGame(Integer gameId) {
        Game game = new Game();
        game.setId(gameId);
        games.add(game);
        return game;
    }

    public Game findGameById(Integer id) {
        return games.stream().filter(g -> g.getId().equals(id)).findFirst().orElse(null);
    }

    public void addPlayerToGame(Player player, Integer id) {
        Game game = findGameById(id);
        if (game != null) {
            List<Player> players = game.getPlayers();
            if (players == null){
                players = new ArrayList<>();
            }
            player.setGameId(id);
            players.add(player);
            game.setPlayers(players);
        } else {
            throw new NullPointerException("Game does not exists!");
        }
    }

    public void addHandAndHandResultToGame(Hand hand, HandResult handResult, Integer id) {
        Game game = findGameById(id);
        if (game != null){
            hand.setGameId(game.getId());
            List<HandResult> handResults ;
            handResults = game.getHandResults();
            if (handResults == null){
                handResults = new ArrayList<>();
            }
            // hand result already contains the result information but not add to the game for trace
            handResults.add(handResult);
            game.setHandResults(handResults);
        }else{
            throw new NullPointerException("Game does not exists!");
        }
    }

    public void changeStatusForGame(Integer id, Status status){
        Game game = findGameById(id);
        if (game != null){
            game.setStatus(status);
        }else{
            throw new NullPointerException("Game does not exists");
        }
    }

    public void changeGameRound(Integer id, Integer currentRound, Integer currentRepeat, Integer riichiLeftOver){
        Game game = findGameById(id);
        if (game != null){
            game.setCurrentRound(currentRound);
            game.setCurrentRepeat(currentRepeat);
            game.setRiichiLeftover(riichiLeftOver);
        }else{
            throw new NullPointerException("Game does not exists");
        }
    }

    public List<Game> findAll() {
        return this.games;
    }
}

