package com.ivy.sanaa.art.contollers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivy.sanaa.art.art.Artists;

import java.io.IOException;

@WebServlet("/login")
public class LoginContoller<userService, UserService> extends HttpServlet {

    public LoginContoller() {
        new Artists();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", new User());
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
