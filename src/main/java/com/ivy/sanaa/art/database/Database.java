package com.ivy.sanaa.art.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ivy.sanaa.art.application.model.entities.Artwork;
import com.ivy.sanaa.art.art.Exhibition;

public class Database<User> implements Serializable {

 private List<Artwork> artworks = new ArrayList<>();
    private List<Exhibition> exhibitions = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private static Database dbInstance;

    private Database() {
    }

    public static Database getDbInstance() {
        if (dbInstance == null) {
            dbInstance = new Database();
            System.out.println("Art Gallery Database instance created");
        }
        return dbInstance;
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<Artwork> artworks) {
        if (artworks != null) {
            this.artworks = artworks;
        }
    }

    public List<Exhibition> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(List<Exhibition> exhibitions) {
        if (exhibitions != null) {
            this.exhibitions = exhibitions;
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        if (users != null) {
            this.users = users;
        }
    }
}

