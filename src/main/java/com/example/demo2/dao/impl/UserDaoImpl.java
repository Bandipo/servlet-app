package com.example.demo2.dao.impl;

import com.example.demo2.dao.UserDao;
import com.example.demo2.dtos.UserDto;
import com.example.demo2.models.User;
import com.example.demo2.util.DataBaseConnection;
import com.mysql.cj.util.StringUtils;
import lombok.NonNull;

import java.sql.*;
import java.time.LocalDate;

public class UserDaoImpl implements UserDao {
    final static String USER_INSERT_SQL = "insert into users (first_name, last_name, email, password, dob) " + "values (?,?,?,?,?)";

    final static  String SELECT_USE_BY_USENAME_AND_PASSWORD= "select * from users where email = ? and password = ?";

    @Override
    public User saveUser(UserDto userDto) {

        User savedCustomer = null ;



        try( Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection()){

            PreparedStatement statement = connection.prepareStatement(USER_INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, userDto.getFirstName());
            statement.setString(2, userDto.getLastName());
            statement.setString(3, userDto.getEmail());
            statement.setString(4, userDto.getPassword());
            statement.setDate(5, Date.valueOf(userDto.getDob()));

            int result = statement.executeUpdate();

            final ResultSet keysResultSet = statement.getGeneratedKeys();
            keysResultSet.next();
            final long autogenerateId = keysResultSet.getLong(1);

            savedCustomer =  result == 1? new User(autogenerateId, userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword(), userDto.getDob()) : null;



        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return savedCustomer;
    }

    @Override
    public User findUserByEmailAndPassword(@NonNull String email, @NonNull String password) {

       User foundUser = null;

        try(Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USE_BY_USENAME_AND_PASSWORD);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
            long  foundId = resultSet.getLong("id");
                String first_name = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String  foundEmail =      resultSet.getString("email");
                String  foundPassword =   resultSet.getString("password");
                LocalDate date = resultSet.getDate("dob").toLocalDate();

                foundUser = User.builder()
                        .id(foundId)
                        .firstName(first_name)
                        .lastName(lastName)
                        .email(foundEmail)
                        .password(foundPassword)
                        .dob(date)
                        .build();

            }



        }catch (Exception e){
            System.out.println(e.getMessage());
        }




        return foundUser;
    }
}
