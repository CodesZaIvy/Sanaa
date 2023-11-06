package com.ivy.sanaa.art.contollers;

import com.ivy.sanaa.art.art.ArtWorks;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/artwork")
public class ArtType<Artwork> extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Fetch the artwork ID from the request parameter
        int artworkId = Integer.parseInt(request.getParameter("id")); // Assuming the 'id' parameter is passed in the URL

        // Fetch artwork details from the database (or any data source)
        ArtWorks artwork = fetchArtworkFromDatabase(artworkId); // Fetch the artwork based on the ID

        // Display the details in a simple HTML response
        out.println("<html><body>");
        out.println("<h1>Artwork Details</h1>");
        out.println("<p>ID: " + artwork.getId() + "</p>");
        out.println("<p>Title: " + artwork.getTitle() + "</p>");
        // Add more details as needed

        out.println("</body></html>");
    }

    // Example method for fetching artwork from a data source (database)
    private ArtWorks fetchArtworkFromDatabase(int id) {
        // Simulated method, replace this with your database retrieval logic
        // Fetch the artwork with 'id' from the database
        // Return the fetched Artwork object
        return new ArtWorks(id, "Artwork Title", "Description", "Category", "Label", 100, 0, "image.jpg", 1);
    }
}

