package controllers;

import models.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageController {
    private final List<Storage> storageList = new ArrayList<>();

    // Thêm tài sản vào kho
    public String addAssetToStorage(String storageId, String assetId, String location, int quantity) {
        for (Storage storage : storageList) {
            if (storage.getStorageId().equals(storageId) && storage.getAssetId().equals(assetId)) {
                storage.setQuantity(storage.getQuantity() + quantity);
                return "Asset quantity updated successfully!";
            }
        }

        storageList.add(new Storage(storageId, assetId, location, quantity));
        return "Asset added to storage successfully!";
    }

    // Xóa tài sản khỏi kho
    public String deleteAssetFromStorage(String storageId, String assetId) {
        return storageList.removeIf(storage ->
                storage.getStorageId().equals(storageId) && storage.getAssetId().equals(assetId))
                ? "Asset removed from storage successfully!"
                : "Asset not found in storage!";
    }

    // Lấy tất cả tài sản trong kho
    public List<Storage> getAllAssetOnStorage() {
        return storageList;
    }
}
