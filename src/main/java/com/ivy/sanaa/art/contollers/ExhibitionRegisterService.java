package com.ivy.sanaa.art.contollers;

import com.ivy.sanaa.art.art.Exhibition;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerExhibition")
public class ExhibitionRegisterService extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch form parameters
        String confirm = request.getParameter("confirm");
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int exhibition_id = Integer.parseInt(request.getParameter("exhibition_id"));

        // Create an ExhibitionRegister object
        Exhibition exhibitionRegister = new Exhibition();
        exhibitionRegister.setConfirm(confirm);
        exhibitionRegister.setUser_id(user_id);
        exhibitionRegister.setExhibition_id(exhibition_id);

        // Your database handling logic
        // Insert the details into the database or perform any other necessary operations

        // Redirect to a success page or appropriate destination
        response.sendRedirect(request.getContextPath() + "/success.jsp");
    }
}

