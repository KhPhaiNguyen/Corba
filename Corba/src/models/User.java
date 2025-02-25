package models;

public class User {
    public String userId;
    public String username;
    public String password;  // Trong thực tế nên hash mật khẩu.
    public String role;

    public User(String userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("User{id='%s', username='%s', role='%s'}", userId, username, role);
    }
}
