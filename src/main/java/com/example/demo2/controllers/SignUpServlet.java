package com.example.demo2.controllers;

import com.example.demo2.dao.UserDao;
import com.example.demo2.dao.impl.UserDaoImpl;
import com.example.demo2.dtos.UserDto;
import com.example.demo2.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "SignUpServlet", value = "/sign-up")
public class SignUpServlet extends HttpServlet {

    private  static UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        String dateOfBirth = request.getParameter("dob");

        UserDto userDto = new UserDto(firstName, lastName, email, password, LocalDate.parse(dateOfBirth));

        userDao.saveUser(userDto);


        request.getRequestDispatcher("/home.jsp")
                .forward(request, response);



    }
}
