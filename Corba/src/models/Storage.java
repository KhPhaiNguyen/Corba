package models;

public class Storage {
    private String storageId;
    private String assetId;
    private String location;
    private int quantity;

    public Storage(String storageId, String assetId, String location, int quantity) {
        this.storageId = storageId;
        this.assetId = assetId;
        this.location = location;
        this.quantity = quantity;
    }

    public String getStorageId() {
        return storageId;
    }

    public String getAssetId() {
        return assetId;
    }

    public String getLocation() {
        return location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Storage{id='%s', assetId='%s', location='%s', quantity=%d}",
                storageId, assetId, location, quantity);
    }
}
