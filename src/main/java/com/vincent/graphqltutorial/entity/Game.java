package com.vincent.graphqltutorial.entity;

import com.vincent.graphqltutorial.enumeration.Status;
import lombok.Data;
import lombok.ToString;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;

@Data
@SchemaMapping
@ToString
public class Game {
    Integer id;
    Integer currentRepeat;
    Integer currentRound;
    Integer riichiLeftover;
    Integer honba;
    List<HandResult> handResults;
    List<Player> players;
    Score score;
    Status status = Status.IN_PROGRESS;
}
