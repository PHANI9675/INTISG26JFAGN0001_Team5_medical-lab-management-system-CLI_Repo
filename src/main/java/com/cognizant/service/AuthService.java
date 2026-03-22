package com.cognizant.service;

import com.cognizantTest.dao.UserDAO;
import com.cognizantTest.model.Role;
import com.cognizantTest.model.User;

public class AuthService {
    private UserDAO dao = new UserDAO();
    private static final String ADMIN_PASSCODE = "ADMIN123";

    public void register(String username, String password, String roleInput, String passcode) {
        Role role;

        if (roleInput.equalsIgnoreCase("ADMIN")) {
            if (!ADMIN_PASSCODE.equals(passcode)) {
                System.out.println("Invalid Credentials! ");
                return;
            }

            role = Role.ADMIN;
        } else {
            role = Role.USER;
        }

        dao.save(new User(0, username, password, role));
        System.out.println("Registered Successfully");
    }

    public User login(String username, String password) {
        User user = dao.findUserByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("Invalid Credentials");
            return null;
        }

        System.out.println("Login Successful ");
        return user;
    }
}

