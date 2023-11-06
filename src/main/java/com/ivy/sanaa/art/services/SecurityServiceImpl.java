package com.ivy.sanaa.art.services;

import javax.servlet.http.HttpSession;

public class SecurityServiceImpl<UserDetails> {

    private UserDetailsServiceImpl userDetailsService;

    public SecurityServiceImpl(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("username") != null;
    }

    public String findLoggedInUsername(HttpSession session) {
        return (String) session.getAttribute("username");
    }

    public void autoLogin(HttpSession session, String username, String password) {
        if (userDetailsService != null) {
            // Load user details by username (implement logic to authenticate)
            Object userDetails = userDetailsService.loadUserByUsername(username);

            // Example: Check if password matches (Implement your secure logic here)
            if (userDetails != null && userDetails.getPassword().equals(password)) {
                session.setAttribute("username", userDetails.getUsername());
                session.setAttribute("loggedIn", true);
            }
        }
    }

    public void logout(HttpSession session) {
        session.invalidate(); // Invalidates the session upon logout
    }
}
