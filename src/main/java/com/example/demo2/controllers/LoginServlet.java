package com.example.demo2.controllers;

import com.example.demo2.dao.UserDao;
import com.example.demo2.dao.impl.UserDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
   private  static UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the request parameters
        String email = request.getParameter("email");

        String password = request.getParameter("password");



        // validate if the user exists in Database

        boolean isUserExist = userDao.existsUserByEmailAndPassword(email, password);

        System.out.println("user exists: "+ isUserExist);

    }

}
