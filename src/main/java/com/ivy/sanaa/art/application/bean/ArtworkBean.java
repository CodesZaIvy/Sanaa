package com.ivy.sanaa.art.application.bean;

import java.io.Serializable;
import java.util.List;

import com.ivy.sanaa.art.art.ArtWorks;

public class ArtworkBean<CategoryStatus> implements Serializable {
    public String listOfArtworks() {
        List<ArtWorks> artworks = Database.getDbInstance().getArtworks();

        StringBuilder sb = new StringBuilder();
        for (ArtWorks artwork : artworks) {

            sb.append("<div class=\"artwork-section\">");
            sb.append("<div class=\"artwork-content\">");
            sb.append("<img src=\"").append(artwork.getImgUrl()).append("\" alt=\"").append(artwork.getTitle())
                    .append("\" style=\"width:100%\">");
            sb.append("<h2>").append(artwork.getTitle()).append("</h2>");
            sb.append("<p>").append("Category: ").append(artwork.getCategory()).append("</p>");
            sb.append("<p>").append("Label: ").append(artwork.getLabel()).append("</p>");
            sb.append("<p>").append("Price: ").append(artwork.getPrice()).append("</p>");
            sb.append("<p>").append("Description: ").append(artwork.getDescription()).append("</p>");
            sb.append("</div>");
            sb.append("</div>");

        }

        return sb.toString();
    }

    public ArtWorks addArtwork(ArtWorks artwork) throws Exception {
        Database db = Database.getDbInstance();
        db.getArtworks().add(artwork);
        return artwork;
    }

    public void deleteArtwork(ArtWorks artwork) {
        Database db = Database.getDbInstance();
        db.getArtworks().remove(artwork);
    }

    public void addArtwork(String title, String image, String category, String label, int price, String description) {
        Database db = Database.getDbInstance();
        db.getArtworks().add(new ArtWorks(title, image, category, label, price, description));
    }

    public String getFeaturedArtwork() {
        List<ArtWorks> artworks = Database.getDbInstance().getArtworks();

        StringBuilder sb = new StringBuilder();
        if (!artworks.isEmpty()) {
            ArtWorks artwork = artworks.get(5);
            sb.append("<div class=\"main-page-feature\">");

            sb.append("<img src=\"").append(artwork.getImgUrl()).append("\" alt=\"").append(artwork.getTitle())
                    .append("\" style=\"width:100%\">");
            sb.append("<h2>").append(artwork.getTitle()).append("</h2>");
            sb.append("</div>");
        }

        sb.append("<div class=\"main-page-feature\">");
        sb.append("<a href=\"./artworks\" class=\"btn btn-primary\">View All ArtWorks</a>");
        sb.append("</div>");
        sb.append("<div class=\"main-page-feature\">");
        sb.append("<a href=\"./categories\" class=\"btn btn-primary\">View Categories</a>");
        sb.append("</div>");

        return sb.toString();
    }

    public List<ArtWorks> getArtworks() {
        return Database.getDbInstance().getArtworks();
    }

    public String getCategories() {
        // list of categories

        List<CategoryStatus> categories = List.of(CategoryStatus.values());

        StringBuilder sb = new StringBuilder();
        for (CategoryStatus category : categories) {
            sb.append("<div class=\"main-page-feature\">");
            sb.append("<a href=\"./categories?category=").append(category).append("\" class=\"btn btn-primary\">")
                    .append(category).append("</a>");
            sb.append("</div>");

        }

        return sb.toString();

    }

    public String sortPerCategory(CategoryStatus category) {
        List<ArtWorks> artworks = getArtworks();
        // filter artworks per category

        List<ArtWorks> filteredArtworks = artworks.stream().filter(artwork -> artwork.getCategory().equals(category))
                .collect(java.util.stream.Collectors.toList());


        StringBuilder sb = new StringBuilder();
        for (ArtWorks artwork : filteredArtworks) {

            sb.append("<div class=\"artwork-section\">");
            sb.append("<div class=\"artwork-content\">");
            sb.append("<img src=\"").append(artwork.getImgUrl()).append("\" alt=\"").append(artwork.getTitle())
                    .append("\" style=\"width:100%\">");
            sb.append("<h2>").append(artwork.getTitle()).append("</h2>");
            sb.append("<p>").append("Category: ").append(artwork.getCategory()).append("</p>");
            sb.append("<p>").append("Label: ").append(artwork.getLabel()).append("</p>");
            sb.append("<p>").append("Price: ").append(artwork.getPrice()).append("</p>");
            sb.append("<p>").append("Description: ").append(artwork.getDescription()).append("</p>");
            sb.append("</div>");
            sb.append("</div>");

        }

        return sb.toString();
    }
}

