package com.ivy.sanaa.art.services;

import java.util.List;

import com.ivy.sanaa.art.application.model.entities.Artwork;

public interface ArtworkService<User> {

    List<Artwork> getArtworks();
    void save(Artwork artwork, User user);
    Artwork findArtworkById(int id);
    List<Artwork> findArtworkByOwner(int id);
    void updateArtwork(int id);
    void updateArtworkLikes(int id, int likes);
    String getArtOwnerName(Artwork artwork);


}
