package com.ivy.sanaa.art.services;

import java.util.List;

import com.ivy.sanaa.art.application.model.entities.Artwork;

public class ArtworkServiceImpl<ArtworkRepository, UserRepository> {
    public ArtworkRepository artworkRepository;
    public UserRepository userRepository;

    public ArtworkServiceImpl(ArtworkRepository artworkRepository, UserRepository userRepository) {
        this.artworkRepository = artworkRepository;
        this.userRepository = userRepository;
    }

    public void save(Artwork artwork, User user) {
        System.out.println(user.getId());
        artwork.setOwner_id(user.getId());
        artwork.setLikes(0);
        artwork.setLabel("Verifying");
        String imgUrl = "/img/artwork-photos/" + artwork.getId() + "/" + artwork.getImgUrl();
        artwork.setImgUrl(imgUrl);
        System.out.println(artwork.getImgUrl());
        artworkRepository.save(artwork);
    }

    public List<Artwork> getArtworks() {
        return artworkRepository.findAllArtworks();
    }

    public Artwork findArtworkById(int id) {
        return artworkRepository.findArtworkById(id);
    }

    public List<Artwork> findArtworkByOwner(int id) {
        return artworkRepository.findArtworkByOwner(id);
    }

    public void updateArtwork(int id) {
        artworkRepository.updateArtwork(id);
    }

    public void updateArtworkLikes(int id, int likes) {
        artworkRepository.updateArtworkLikes(id, likes);
    }

    public String getArtOwnerName(Artwork artwork) {
        User user = userRepository.findByUserId(artwork.getOwner_id());
        String name = user.getFirstName();
        return name;
    }
}
