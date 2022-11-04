package com.example.demo2.controllers;

import com.example.demo2.dao.UserDao;
import com.example.demo2.dao.impl.UserDaoImpl;
import com.example.demo2.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
   private  static final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the request parameters
        String email = request.getParameter("email");

        String password = request.getParameter("password");

        System.out.println(email);
        System.out.println(password);

        // validate if the user exists in Database

        User foundUser = userDao.findUserByEmailAndPassword(email, password);

        // if the user is not found



        if(foundUser == null){
            request.setAttribute("errorMessage", "User Not Found, Kindly register");
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }



        // store the user in session


           HttpSession requestSession = request.getSession();

           requestSession.setAttribute("loggedUser", foundUser);


        // redirect to dashboard.jsp

        request.getRequestDispatcher("/dashboard.jsp")
                .forward(request, response);

    }

}
