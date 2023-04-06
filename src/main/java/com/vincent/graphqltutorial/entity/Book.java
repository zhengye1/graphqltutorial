package com.vincent.graphqltutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    String id;
    String name;
    int pageCount;
    String authorId;
}
