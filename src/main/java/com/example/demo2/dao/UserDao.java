package com.example.demo2.dao;

import com.example.demo2.dtos.UserDto;
import com.example.demo2.models.User;
import lombok.NonNull;

public interface UserDao {

    User saveUser(UserDto userDto);

    User findUserByEmailAndPassword(@NonNull String email, @NonNull String password);
}
