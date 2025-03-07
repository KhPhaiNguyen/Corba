import models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static List<Asset> assets = new ArrayList<>();
    public static List<Client> clients = new ArrayList<>();
    public static List<Storage> storage = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    static {
        // Thêm dữ liệu vào danh sách assets
        assets.add(new Asset(1, "Laptop", "Nguyen", "available", LocalDateTime.of(2025, 3, 2, 10, 0)));
        assets.add(new Asset(2, "Iphone", "Hoang", "borrowed", LocalDateTime.of(2025, 3, 1, 15, 30)));
        assets.add(new Asset(3, "Printer", "Nguyen", "maintenance", LocalDateTime.of(2025, 2, 28, 9, 45)));

        // Thêm dữ liệu vào danh sách clients
        clients.add(new Client("C001", "Nguyen", "Nguyen@example.com", LocalDateTime.of(2025, 2, 25, 14, 0)));
        clients.add(new Client("C002", "Hoang", "Nguyen@example.com", LocalDateTime.of(2025, 2, 26, 9, 15)));

        // Thêm dữ liệu vào danh sách storage
        storage.add(new Storage("S001", "Laptop Dell", 1500.00, 5, 2, 12));
        storage.add(new Storage("S002", "Iphone", 700.00, 3, 1, 6));
        storage.add(new Storage("S003", "Printer", 1000.00, 2, 1, 5));

        // Thêm dữ liệu vào danh sách users
        users.add(new User(1, "admin", "admin123", "admin", LocalDateTime.of(2025, 2, 20, 8, 0)));
        users.add(new User(2, "user1", "user123", "user", LocalDateTime.of(2025, 2, 22, 10, 30)));
    }

    public static void printAllData() {
        System.out.println("Assets:");
        assets.forEach(System.out::println);

        System.out.println("\nClients:");
        clients.forEach(System.out::println);

        System.out.println("\nStorage:");
        storage.forEach(System.out::println);

        System.out.println("\nUsers:");
        users.forEach(System.out::println);
    }
}
