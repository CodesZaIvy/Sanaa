package com.ivy.sanaa.art.contollers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Security;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/exhibition")
public class Exhibition<UserService, SecurityService> extends HttpServlet {

    private com.ivy.sanaa.art.art.Exhibition exhibitionService;

    public void ExhibitionServlet(com.ivy.sanaa.art.art.Exhibition exhibitionService, SecurityService securityService, UserService userService, ExhibitionRegisterService exhibitionRegisterService) {
        this.exhibitionService = exhibitionService;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exhibition> exhibitions = exhibitionService.getExhibitions();
        request.setAttribute("exhibitions", exhibitions);
        request.getRequestDispatcher("exhibition.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exhibition exhibition = new Exhibition();
        exhibition.setTitle(request.getParameter("title"));
        exhibition.setDatetime(Timestamp.valueOf(request.getParameter("localDatetime").replace("T", " ")));

        int currentUserId;
        try {
            currentUserId = getUserLoggedInUserId(request);
        } catch (Exception e) {
            response.sendRedirect("/login");
            return;
        }

        String fileName = request.getPart("image").getSubmittedFileName();
        exhibition.setImgUrl(fileName);

        exhibitionService.save(exhibition);

        String uploadDir = "src/main/resources/static/img/exhibition-photos/" + exhibition.getId();
        saveFile(uploadDir, fileName, request.getPart("image").getInputStream());

        response.sendRedirect("/exhibition");
    }

    private void setImgUrl(String fileName) {
    }

    private void setTitle(String parameter) {
    }

    private void setDatetime(Timestamp valueOf) {
    }

    private int getUserLoggedInUserId(HttpServletRequest request) {
        // Simulate user login logic using the session or request data
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

    


