package com.ivy.sanaa.art.contollers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/workshop")
public class Workshop<UserService, WorkshopService, WorkshopRegisterService> extends HttpServlet {
    private Security securityService;
    private UserService userService;
    private WorkshopService workshopService;
    private WorkshopRegisterService workshopRegisterService;

    public void init() {
        securityService = new SecurityService();
        userService = new UserService();
        workshopService = new WorkshopService();
        workshopRegisterService = new WorkshopRegisterService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Workshop> workshops = workshopService.getWorkshops();
        Map<Object, String> workshopAndOrganizer = new HashMap<>();
        for (Workshop workshop : workshops) {
            workshopAndOrganizer.put(workshop, workshopService.getWorkshopOrganizerName(workshop));
        }
        request.setAttribute("workshops", workshops);
        request.setAttribute("workshopAndOrganizer", workshopAndOrganizer);
        request.getRequestDispatcher("workshop.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implement post requests for registering to workshops
        // Handle organize workshop functionalities
    }
}

