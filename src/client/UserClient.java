package client;

import AssetManagement.UserService;
import AssetManagement.UserServiceHelper;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class UserClient {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            UserService userService = UserServiceHelper.narrow(ncRef.resolve_str("UserService"));

            System.out.println("Them nguoi dung:");
            userService.addUser("U300", "Tran Thi B");

        } catch (Exception e) {
            System.err.println("Loi trong UserClient: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
