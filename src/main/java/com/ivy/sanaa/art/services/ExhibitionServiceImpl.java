package com.ivy.sanaa.art.services;

import java.util.List;

public class ExhibitionServiceImpl<ExhibitionRepository> {

    private ExhibitionRepository exhibitionRepository;

    public ExhibitionServiceImpl(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    public List<com.ivy.sanaa.art.art.Exhibition> getExhibitions() {
        return exhibitionRepository.getExhibitions();
    }

    public void save(com.ivy.sanaa.art.art.Exhibition exhibition) {
        exhibition.setRegistered_seats(0);
        String imgUrl = "/img/exhibition-photos/" + exhibition.getId() + "/" + exhibition.getImgUrl();
        exhibition.setImgUrl(imgUrl);
        exhibition.setStatus("notDone");
        exhibitionRepository.save(exhibition);
    }

    public <Exhibition> Exhibition findExhibitionById(int id) {
        return exhibitionRepository.findExhibitionById(id);
    }

    public void updateExhibitionSeats(int id, int seats) {
        exhibitionRepository.updateExhibitionSeats(id, seats);
    }

    public void updateExhibitionStatus(int id) {
        exhibitionRepository.updateExhibitionStatus(id);
    }
}
