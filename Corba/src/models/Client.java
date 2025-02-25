package models;

public class Client {
    public String clientId;
    public String name;
    public String email;
    public String phone;

    public Client(String clientId, String name, String email, String phone) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Client{id='%s', name='%s', email='%s', phone='%s'}",
                clientId, name, email, phone);
    }
}
