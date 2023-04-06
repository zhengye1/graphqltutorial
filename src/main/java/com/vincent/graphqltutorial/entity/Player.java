package com.vincent.graphqltutorial.entity;

import com.vincent.graphqltutorial.enumeration.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Player {
    Long id;
    Long userId;
    Integer gameId;
    Direction startingWind;
}
