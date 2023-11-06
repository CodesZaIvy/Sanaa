package com.ivy.sanaa.art.contollers;

import com.ivy.sanaa.art.art.ArtWorks;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shop")
public class Shop<UserService, ArtworkService, SecurityService> extends HttpServlet {
    private UserService userService;
    private ArtworkService artworkService;
    private SecurityService securityService;

    public void init() {
        userService = new UserService();
        artworkService = new ArtWorks();
        securityService = new SecurityService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ArtWorks> artworks = artworkService.getAllArtworks();
        request.setAttribute("artworks", artworks);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle post actions like accepting/declining artworks
    }
}

