package com.vincent.graphqltutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hand {
    Long id;
    Integer gameId;
    Integer round;
    Integer repeat;
}
