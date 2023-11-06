package com.ivy.sanaa.art.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl<UserRepository, UserDetails, GrantedAuthority> {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public <User> UserDetails loadUserByUsername(String email) throws UserPrincipalNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found with email: " + email);
        }

        List<GrantedAuthority> grantList = new ArrayList<>();
        String role = user.getRole();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        grantList.add(authority);

        System.out.println(grantList);

        // Assuming you have a custom UserDetails class implementing UserDetails
        // This should be a simple version of UserDetails tailored for your application
        return new CustomUserDetails(user.getEmail(), user.getPassword(), grantList);
    }
}
