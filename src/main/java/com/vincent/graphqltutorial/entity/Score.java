package com.vincent.graphqltutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Score {
    Integer EAST;
    Integer SOUTH;
    Integer WEST;
    Integer NORTH;
}
