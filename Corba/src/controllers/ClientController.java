package controllers;

import models.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private final List<Client> clients = new ArrayList<>();

    // Thêm khách hàng mới
    public String addClient(String clientId, String name, String email, String phone) {
        for (Client client : clients) {
            if (client.clientId.equals(clientId)) {
                return "Client ID already exists!";
            }
        }
        clients.add(new Client(clientId, name, email, phone));
        return "Client added successfully!";
    }

    // Lấy tất cả khách hàng
    public List<Client> getAllClient() {
        return clients;
    }
}
