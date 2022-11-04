package com.example.demo2.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PostServlet", value = "/timeline")
public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("user-id");
        String post = request.getParameter("post-text");


        System.out.println("userId: "+userId);
        System.out.println("post: "+post);

        // create your post

        // save your post

        //get all posts

        //if the posts is not empty, add the posts to requestAttribute

        // forward the request on the same jsp




    }
}
