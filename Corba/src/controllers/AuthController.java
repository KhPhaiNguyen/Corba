package controllers;

import models.User;
import java.util.List;

public class AuthController {
    private final UserController userController = new UserController();

    // Đăng nhập người dùng dựa trên danh sách UserController
    public String loginUser(String username, String password) {
        List<User> users = userController.getAllUsers();
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return "Login successful! Welcome, " + user.username + ". Role: " + user.role;
            }
        }
        return "Login failed! Invalid username or password.";
    }
}
