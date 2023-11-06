package com.ivy.sanaa.art.application.outlook.html;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ivy.sanaa.art.application.outlook.css.CssApplication;

import java.io.IOException;
import java.io.PrintWriter;

public class ApplicationPage implements Serializable {
    public void renderHtml(HttpServletRequest req, HttpServletResponse res, int activeMenu, String content)
            throws IOException {
        HttpSession session = req.getSession();
        ServletContext context = req.getServletContext();
        PrintWriter print = res.getWriter();

        print.write("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>" + context.getInitParameter("AppName") + "</title>" +
                "<meta charset=\"UTF-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">" + // Example using Bootstrap
                new CssApplication().getStyle() +
                "</head>" +
                "<body>");

        // Top navigation toolbar with active menu passed in
        print.write(new TopTaskbar().menu(activeMenu));

        // Art Gallery Website Header
        print.write("<div class=\"jumbotron text-center\">" +
                "<h1>" + context.getInitParameter("AppName") + "</h1>" +
                "<p>An exquisite collection of art</p>" +
                "</div>");

        // Main content section
        print.write("<div class=\"container\">" +
                "<div class=\"row\">");

        // Display the content
        print.write("<div class=\"col-md-12\">" +
                content +
                "</div>");

        print.write("</div>" + // Close the row
                "</div>"); // Close the container

        // Additional JavaScript libraries or scripts can be included here

        print.write(
                "</body>" +
                        "</html>");
    }
}


