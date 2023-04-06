package com.vincent.graphqltutorial.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;

@Data
@SchemaMapping
@ToString
public class HandResult {
    Score scoreDelta;
    Integer riichiLeftover;
    Integer honba;
    Integer nextRound;
    Integer nextRepeat;
    Integer round;
    Integer repeat;
    List<HandEvent> events;

}
