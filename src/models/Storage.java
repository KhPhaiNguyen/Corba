package models;

public class Storage {
    private String id;
    private String name;
    private double value;
    private int quantity;
    private int borrowed;
    private int maintenancePeriod;

    public Storage(String id, String name, double value, int quantity, int borrowed, int maintenancePeriod) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.borrowed = borrowed;
        this.maintenancePeriod = maintenancePeriod;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                ", borrowed=" + borrowed +
                ", maintenancePeriod=" + maintenancePeriod +
                '}';
    }
}
