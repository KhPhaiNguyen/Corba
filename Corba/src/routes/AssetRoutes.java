package routes;

import controllers.AssetController;
import models.Asset;
import static spark.Spark.*;

public class AssetRoutes {
    private static final AssetController assetController = new AssetController();

    public static void init() {
        // Thêm tài sản mới
        post("/assets/add", (req, res) -> {
            String assetId = req.queryParams("assetId");
            String name = req.queryParams("name");
            String type = req.queryParams("type");
            String status = req.queryParams("status");
            String ownerId = req.queryParams("ownerId");

            return assetController.addAsset(assetId, name, type, status, ownerId);
        });

        // Lấy tất cả tài sản
        get("/assets", (req, res) -> assetController.getAllAssets());

        // Lấy tài sản theo trạng thái
        get("/assets/status/:status", (req, res) ->
                assetController.getAssetByStatus(req.params(":status"))
        );

        // Lấy tài sản theo chủ sở hữu
        get("/assets/owner/:ownerId", (req, res) ->
                assetController.getAssetByOwner(req.params(":ownerId"))
        );

        // Lấy tài sản theo loại
        get("/assets/type/:type", (req, res) ->
                assetController.getAssetByType(req.params(":type"))
        );

        // Cập nhật trạng thái tài sản
        put("/assets/updateStatus", (req, res) -> {
            String assetId = req.queryParams("assetId");
            String newStatus = req.queryParams("status");
            return assetController.updateStatus(assetId, newStatus);
        });

        // Xóa tài sản theo ID
        delete("/assets/delete/:assetId", (req, res) ->
                assetController.deleteAsset(req.params(":assetId"))
        );
    }
}
