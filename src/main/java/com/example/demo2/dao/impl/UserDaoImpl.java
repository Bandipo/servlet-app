package com.example.demo2.dao.impl;

import com.example.demo2.dao.UserDao;
import com.example.demo2.dtos.UserDto;
import com.example.demo2.models.User;
import com.example.demo2.util.DataBaseConnection;
import com.mysql.cj.util.StringUtils;
import lombok.NonNull;

import java.sql.*;

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
    public boolean existsUserByEmailAndPassword(@NonNull String email, @NonNull String password) {

       boolean  returnType = false;

       long foundId = 0;
        String foundEmail = null;
        String foundPassword = null;

        try(Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USE_BY_USENAME_AND_PASSWORD);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
              foundId = resultSet.getLong("id");
             foundEmail =      resultSet.getString("email");
             foundPassword =   resultSet.getString("password");
            }

            System.out.println(foundEmail);

            System.out.println(foundPassword);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }




        return foundId > 0;
    }
}
