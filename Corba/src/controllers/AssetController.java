package controllers;

import models.Asset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssetController {
    private final List<Asset> assets = new ArrayList<>();

    // Thêm tài sản
    public String addAsset(String assetId, String name, String type, String status, String ownerId) {
        Asset newAsset = new Asset(assetId, name, type, status, ownerId);
        assets.add(newAsset);
        return "Asset added successfully!";
    }

    // Lấy tất cả tài sản
    public List<Asset> getAllAssets() {
        return assets;
    }

    // Lấy tài sản theo trạng thái
    public List<Asset> getAssetByStatus(String status) {
        return assets.stream()
                .filter(asset -> asset.status.equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    // Lấy tài sản theo chủ sở hữu
    public List<Asset> getAssetByOwner(String ownerId) {
        return assets.stream()
                .filter(asset -> asset.ownerId.equalsIgnoreCase(ownerId))
                .collect(Collectors.toList());
    }

    // Lấy tài sản theo loại
    public List<Asset> getAssetByType(String type) {
        return assets.stream()
                .filter(asset -> asset.type.equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    // Cập nhật trạng thái tài sản
    public String updateStatus(String assetId, String newStatus) {
        for (Asset asset : assets) {
            if (asset.assetId.equals(assetId)) {
                asset.status = newStatus;
                return "Asset status updated successfully!";
            }
        }
        return "Asset not found!";
    }

    // Xóa tài sản theo ID
    public String deleteAsset(String assetId) {
        boolean removed = assets.removeIf(asset -> asset.assetId.equals(assetId));
        return removed ? "Asset deleted successfully!" : "Asset not found!";
    }
}
