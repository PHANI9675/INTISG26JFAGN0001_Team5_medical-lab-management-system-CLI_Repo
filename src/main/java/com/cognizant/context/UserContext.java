package com.cognizantTest.context;

import com.cognizantTest.model.User;

public class UserContext {

    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserContext.currentUser = currentUser;
    }



}
