package com.ivy.sanaa.art.application.bean;

import com.ivy.sanaa.art.art.ArtWorks;

public interface ArtworkInterface {
        String listOfArtworks();
        ArtWorks addArtwork(ArtWorks artwork) throws Exception;
        void deleteArtwork(ArtWorks artwork);
        String getFeaturedArtwork();
        String getCategories();
        String sortPerCategory(String category);
    

    

    

}