package com.ivy.sanaa.art.services;

import com.ivy.sanaa.art.art.Exhibition;
import com.ivy.sanaa.art.art.ExhibitionRegister;

public class ExhibitionRegisterServiceImpl<ExhibitionRegisterRepo> {

    private ExhibitionRegisterRepo exhibitionRegisterRepo;

    public ExhibitionRegisterServiceImpl(ExhibitionRegisterRepo exhibitionRegisterRepo) {
        this.exhibitionRegisterRepo = exhibitionRegisterRepo;
    }

    public <User> void save(ExhibitionRegister exhibitionRegister, User user, Exhibition exhibition) {
        exhibitionRegister.setUser_id(user.getId());
        exhibitionRegister.setExhibition_id(exhibition.getId());
        exhibitionRegisterRepo.save(exhibitionRegister);
    }
}
