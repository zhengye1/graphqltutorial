package com.vincent.graphqltutorial.entity;

import com.vincent.graphqltutorial.enumeration.Direction;
import com.vincent.graphqltutorial.enumeration.HandEventType;
import lombok.Data;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@Data
@SchemaMapping
public class HandEvent {
    Long id;
    Long handId;
    HandEventType type;
    Integer han;
    Integer fu;
    Integer tenpai;
    Direction actor;
    Direction target;
}
