package server;

import AssetManagement.*;
import org.omg.CORBA.*;
import java.util.*;

public class ClientServiceImpl extends ClientServicePOA {
    private ORB orb;
    private final List<String> clients = new ArrayList<>();

    public void setORB(ORB orb) {
        this.orb = orb;
    }

    @Override
    public void addClient(String id, String name) {
        clients.add(id + ": " + name);
        System.out.println("Da them khach hang thanh cong!");
    }

    @Override
    public String[] getAllClients() {
        return clients.toArray(new String[0]);
    }
}
