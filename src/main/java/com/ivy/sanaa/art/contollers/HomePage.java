package com.ivy.sanaa.art.contollers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivy.sanaa.art.art.ArtWorks;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/")
public class HomePage<ArtworkRepository, ArtworkService, WorkshopService> extends HttpServlet {

    private final ArtworkRepository artworkRepository;
    private final ArtworkService artworkService;
    private final WorkshopService workshopService;

    public void HomePageServlet(ArtworkRepository artworkRepository, ArtworkService artworkService, WorkshopService workshopService) {
        this.artworkRepository = artworkRepository;
        this.artworkService = artworkService;
        this.workshopService = workshopService;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ArtWorks> artworks = artworkRepository.getArtworks();
        List<ArtWorks> featured = artworks.subList(artworks.size() - 6, artworks.size());

        Map<Object, String> artAndOwner = new HashMap<>();

        for (ArtWorks artwork : featured) {
            artAndOwner.put(artwork, artworkService.getArtOwnerName(artwork));
        }

        request.setAttribute("artworks", featured);
        request.setAttribute("artAndOwner", artAndOwner);

        List<Workshop> workshops = workshopService.getWorkshops();
        Map<Object, String> workshopAndOrganizer = new HashMap<>();
        for (Workshop workshop : workshops) {
            workshopAndOrganizer.put(workshop, workshopService.getWorkshopOrganizerName(workshop));
        }
        request.setAttribute("workshops", workshops);
        request.setAttribute("workshopAndOrganizer", workshopAndOrganizer);

        request.getRequestDispatcher("homepage.jsp").forward(request, response);
    }

  
}

    

