package server;

import AssetManagement.*;
import org.omg.CORBA.*;
import java.util.*;

public class UserServiceImpl extends UserServicePOA {
    private ORB orb;
    private final List<String> users = new ArrayList<>();

    public void setORB(ORB orb) {
        this.orb = orb;
    }

    @Override
    public void addUser(String id, String name) {
        users.add(id + ": " + name);
        System.out.println("Nguoi dung duoc them thanh cong!");
    }
}
