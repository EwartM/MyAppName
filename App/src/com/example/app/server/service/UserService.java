package com.example.app.server.service;

import com.example.app.server.domain.User;

public class UserService {

    /**
     * PUBLIC
     * Check submitted credentials against DB
     */
    public User authenticate (String submittedEmail, String submittedPassword) {

        User user = null;

        String testEmail = "admin@example.com";
        String testPassword = "admin";

        if (testEmail != null) {
            if (submittedEmail.matches(testEmail) &&
                    submittedPassword.matches(testPassword)) {
                user = new User();
                user.setEmail(submittedEmail);
            }
        }

        return user;
    }
}
