package models;

import java.time.LocalDateTime;

public class Asset {
    private int id;
    private String type;
    private String owner;
    private String status;
    private LocalDateTime createdAt;

    public Asset(int id, String type, String owner, String status, LocalDateTime createdAt) {
        this.id = id;
        this.type = type;
        this.owner = owner;
        this.status = status;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", owner='" + owner + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
