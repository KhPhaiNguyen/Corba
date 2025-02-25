package routes;

import controllers.AuthController;
import static spark.Spark.*;

public class AuthRoutes {
    private static final AuthController authController = new AuthController();

    public static void init() {
        // API đăng nhập
        post("/auth/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");

            if (username == null || password == null) {
                res.status(400);
                return "Username and password are required!";
            }

            return authController.loginUser(username, password);
        });
    }
}
