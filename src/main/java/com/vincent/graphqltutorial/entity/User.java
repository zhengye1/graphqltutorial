package com.vincent.graphqltutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    Long id;
    String name;
}
