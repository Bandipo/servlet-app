package com.example.demo2.models;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Setter
@Getter
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dob;
}
