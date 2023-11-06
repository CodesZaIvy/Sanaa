package com.ivy.sanaa.art.services;

import com.ivy.sanaa.art.art.Exhibition;
import com.ivy.sanaa.art.art.ExhibitionRegister;

public interface ExhibitionRegisterService<User> {
    void save(ExhibitionRegister exhibitionRegister, User user, Exhibition exhibition);
}
