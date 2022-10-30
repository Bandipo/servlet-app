package com.example.demo2.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Setter
@Getter
public class Post {

    private String post;
    private long userId;
}
