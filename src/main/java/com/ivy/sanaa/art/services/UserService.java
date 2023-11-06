package com.ivy.sanaa.art.services;

public interface UserService {

    public <User> void save(User user);
    public <User> User findByUsername(String email);
    public boolean userExists(String email);
    public <User> User findByUserId(int id);


}
