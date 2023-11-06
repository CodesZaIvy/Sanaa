package com.ivy.sanaa.art.contollers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivy.sanaa.art.art.Artists;

import java.io.IOException;

@WebServlet("/register")
public class Registration extends HttpServlet {

    private Artists userService;

    public Registration() {
        // Initialize userService or inject through a constructor
        this.userService = new Artists();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setEmail(request.getParameter("email")); // Retrieve other user details similarly

        if (userService.userExists(user.getEmail())) {
            response.sendRedirect("/registerError");
        } else {
            userService.save(user);
            System.out.println(user);

            response.sendRedirect("/login");
        }
    }
}

