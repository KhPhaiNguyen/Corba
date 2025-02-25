package routes;

import controllers.ClientController;
import models.Client;
import static spark.Spark.*;

public class ClientRoutes {
    private static final ClientController clientController = new ClientController();

    public static void init() {
        // Thêm khách hàng mới
        post("/clients/add", (req, res) -> {
            String clientId = req.queryParams("clientId");
            String name = req.queryParams("name");
            String email = req.queryParams("email");
            String phone = req.queryParams("phone");

            if (clientId == null || name == null || email == null || phone == null) {
                res.status(400);
                return "All fields (clientId, name, email, phone) are required!";
            }

            return clientController.addClient(clientId, name, email, phone);
        });

        // Lấy tất cả khách hàng
        get("/clients", (req, res) -> clientController.getAllClient());
    }
}
