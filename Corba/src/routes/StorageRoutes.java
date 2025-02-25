package routes;

import controllers.StorageController;
import static spark.Spark.*;

public class StorageRoutes {
    private static final StorageController storageController = new StorageController();

    public static void init() {
        // Thêm tài sản vào kho
        post("/storage/add", (req, res) -> {
            String storageId = req.queryParams("storageId");
            String assetId = req.queryParams("assetId");
            String location = req.queryParams("location");
            int quantity = Integer.parseInt(req.queryParams("quantity"));

            if (storageId == null || assetId == null || location == null || quantity <= 0) {
                res.status(400);
                return "All fields (storageId, assetId, location, quantity) are required!";
            }

            return storageController.addAssetToStorage(storageId, assetId, location, quantity);
        });

        // Xóa tài sản khỏi kho
        delete("/storage/delete", (req, res) -> {
            String storageId = req.queryParams("storageId");
            String assetId = req.queryParams("assetId");

            if (storageId == null || assetId == null) {
                res.status(400);
                return "Both storageId and assetId are required!";
            }

            return storageController.deleteAssetFromStorage(storageId, assetId);
        });

        // Lấy tất cả tài sản trong kho
        get("/storage/all", (req, res) -> storageController.getAllAssetOnStorage());
    }
}
