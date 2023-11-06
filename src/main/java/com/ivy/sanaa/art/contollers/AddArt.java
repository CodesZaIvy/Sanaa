package com.ivy.sanaa.art.contollers;

import com.ivy.sanaa.art.art.ArtWorks;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet("/addArt")
public class AddArt<UserService, SecurityService, User> extends HttpServlet {

    private final ArtWorks artworkService;
    private final UserService userService;
    public <ArtworkService> AddArt(ArtWorks artworkService, UserService userService, SecurityService securityService) {
        this.artworkService = artworkService;
        this.userService = userService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int currentUserId;
        try {
            currentUserId = getUserLoggedInUserId(request);
        } catch (Exception e) {
            response.sendRedirect("/login");
            return;
        }

        ArtWorks artwork = new ArtWorks();
        artwork.setTitle(request.getParameter("title")); // Extract parameters from request
        // Extract other artwork information from the request parameters...

        User user = userService.findByUserId(currentUserId);

        artworkService.save(artwork, user);

        Part filePart = request.getPart("image"); // File part from request
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String uploadDir = "src/main/resources/static/img/artwork-photos/" + artwork.getId();
        saveFile(uploadDir, fileName, filePart.getInputStream());

        response.sendRedirect("/homepage");
    }

    private int getUserLoggedInUserId(HttpServletRequest request) {
        // Simulate user login logic using the session or request data
        // You might handle session or request attributes for user authentication
        return 1; // Replace this with your actual logic for extracting user ID
    }

    private void saveFile(String uploadDir, String fileName, InputStream inputStream) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    }
}
