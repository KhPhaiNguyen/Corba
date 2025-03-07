package client;

import AssetManagement.ClientService;
import AssetManagement.ClientServiceHelper;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class ClientClient {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            ClientService clientService = ClientServiceHelper.narrow(ncRef.resolve_str("ClientService"));

            System.out.println("Them khach hang:");
            clientService.addClient("C200", "Nguyen Van A");

            System.out.println("Danh sach khach hang:");
            String[] clients = clientService.getAllClients();
            for (String client : clients) {
                System.out.println(client);
            }

        } catch (Exception e) {
            System.err.println("Loi trong ClientClient: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
