package com.example.demo2.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final LocalDate dob;
}
