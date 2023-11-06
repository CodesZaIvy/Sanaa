package com.ivy.sanaa.art.services;

import java.util.List;

import com.ivy.sanaa.art.art.Exhibition;

public interface ExhibitionService {
    List<Exhibition> getExhibitions();
    void save(Exhibition exhibition);
    Exhibition findExhibitionById(int id);
    void updateExhibitionSeats(int id, int seats);
    void updateExhibitionStatus(int id);
}
