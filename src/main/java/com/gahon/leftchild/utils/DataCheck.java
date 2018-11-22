package com.gahon.leftchild.utils;

import com.gahon.leftchild.model.User;

/**
 * @author Gahon
 */
public class DataCheck {
    public static boolean isUserLegal(User user) {

        return !(user.getUsername().isEmpty() ||
                user.getPassword().isEmpty() ||
                user.getEmail().isEmpty() ||
                user.getPhone().isEmpty() ||
                !(user.getSex() == 0 || user.getSex() == 1)
        );
    }
}
