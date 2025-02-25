package controllers;

import models.User;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final List<User> users = new ArrayList<>();

    public String addUser(String userId, String username, String password, String role) {
        for (User user : users) {
            if (user.userId.equals(userId) || user.username.equals(username)) {
                return "User ID or Username already exists!";
            }
        }
        users.add(new User(userId, username, password, role));
        return "User added successfully!";
    }

    public List<User> getAllUsers() {
        return users;
    }
}
