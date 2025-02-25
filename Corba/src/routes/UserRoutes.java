package routes;

import controllers.UserController;
import static spark.Spark.*;

public class UserRoutes {
    private static final UserController userController = new UserController();

    public static void init() {
        // Thêm người dùng mới
        post("/users/add", (req, res) -> {
            String userId = req.queryParams("userId");
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            String role = req.queryParams("role");

            if (userId == null || username == null || password == null || role == null) {
                res.status(400);
                return "All fields (userId, username, password, role) are required!";
            }

            return userController.addUser(userId, username, password, role);
        });

        // Lấy tất cả người dùng (tuỳ chọn)
        get("/users", (req, res) -> userController.getAllUsers());
    }
}
