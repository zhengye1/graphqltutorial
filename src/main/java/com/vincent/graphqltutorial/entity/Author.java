package com.vincent.graphqltutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
    String id;
    String firstName;
    String lastName;
}
