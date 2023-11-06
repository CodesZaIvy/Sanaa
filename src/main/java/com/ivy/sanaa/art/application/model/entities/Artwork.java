package com.ivy.sanaa.art.application.model.entities;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class Artwork implements Serializable{

  private String title;
    private String imageUrl;
    private String description;
    private String category;
    private String label;
    private int price;
    private int likes;

    public Artwork() {

    }

    public Artwork(String title, String imageUrl, String description, String category, String label, int price, int likes) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.category = category;
        this.label = label;
        this.price = price;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public int getLikes() {
        return likes;
    }

    // create a stringbuilder to append the artwork details in a list HTML format
    public String listStrings() {
        StringBuilder listBuilder = new StringBuilder();
        listBuilder.append("<ul>");
        listBuilder.append("<li>Title: ").append(StringUtils.trimToEmpty(getTitle())).append("</li>");
        listBuilder.append("<li>Image URL: ").append(StringUtils.trimToEmpty(getImageUrl())).append("</li>");
        listBuilder.append("<li>Description: ").append(StringUtils.trimToEmpty(getDescription())).append("</li>");
        listBuilder.append("<li>Category: ").append(StringUtils.trimToEmpty(getCategory())).append("</li>");
        listBuilder.append("<li>Label: ").append(StringUtils.trimToEmpty(getLabel())).append("</li>");
        listBuilder.append("<li>Price: ").append(getPrice()).append("</li>");
        listBuilder.append("<li>Likes: ").append(getLikes()).append("</li>");
        listBuilder.append("</ul>");
        return listBuilder.toString();
    }
}




  
    
    

