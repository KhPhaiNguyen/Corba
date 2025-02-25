package models;

public class Asset {
    public String assetId;
    public String name;
    public String type;
    public String status;
    public String ownerId;

    public Asset(String assetId, String name, String type, String status, String ownerId) {
        this.assetId = assetId;
        this.name = name;
        this.type = type;
        this.status = status;
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return String.format("Asset{id='%s', name='%s', type='%s', status='%s', ownerId='%s'}",
                assetId, name, type, status, ownerId);
    }
}
