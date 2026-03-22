package com.cognizantTest.service;

import com.cognizant.service.AuthService;
import com.cognizantTest.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {
    AuthService authService = new AuthService();

    @Test
    public void testLoginSuccess(){
        authService.register("user", "123", "USER", "");
        User user = authService.login("testuser", "123");
        assertNotNull(user);
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void testLoginFailure(){
        User user = authService.login("wrong", "wrong");
        assertNull(user);
    }
}
