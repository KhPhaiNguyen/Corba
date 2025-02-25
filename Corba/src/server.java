package server;

import static spark.Spark.*;
import routes.AssetRoutes;
import routes.AuthRoutes;
import routes.ClientRoutes;
import routes.UserRoutes;
import routes.StorageRoutes;

public class Server {
    public static void main(String[] args) {
        port(8080);
        System.out.println("Server is running on port 8080...");

        // Khởi tạo các route
        AssetRoutes.init();
        AuthRoutes.init();
        ClientRoutes.init();
        UserRoutes.init();
        StorageRoutes.init();
    }
}
