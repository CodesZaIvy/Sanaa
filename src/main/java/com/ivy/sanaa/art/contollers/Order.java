package com.ivy.sanaa.art.contollers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivy.sanaa.art.art.Orders;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/order")
public class Order<UserService, OrdersService, ArtworkService> extends HttpServlet {

    private UserService userService;
    private OrdersService ordersService;
    private ArtworkService artworkService;

    public Order() {
        // Initialize services, etc.
        this.userService = new UserService();
        this.ordersService = new OrdersService();
        this.artworkService = new ArtworkService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Orders orders = new Orders();
        int artworkId = Integer.parseInt(request.getParameter("artwork_id"));
        int currentUserId = 1; // replace this line with actual user retrieval logic
        orders.setPrice(100); // replace this line with the artwork price retrieval
        orders.setOrdered_at(new Timestamp(new Date().getTime()));

        // Logic to update artwork, save order, and send an email

        // Code to send an email is beyond the scope of Servlets.
        // You would typically use a JavaMail library for email sending.
        // Here is a sample representation of sending an email without specific implementation:
        sendEmail("nairobi.sen.42@gmail.com", "recipient@example.com", "Your email subject", "Your email content");

        response.sendRedirect("/homepage");
    }

    private void sendEmail(String from, String to, String subject, String message) {
        // Your email sending logic would be implemented here using JavaMail or a similar library.
        // This is a simplified representation.
    }
}

