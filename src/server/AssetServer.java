package server;



import AssetManagement.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import java.util.Properties;

public class AssetServer {
    public static void main(String[] args) {
        try {
            // Thiet lap ORB
            Properties props = new Properties();
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            ORB orb = ORB.init(args, props);

            // Lay tham chieu goc POA va kich hoat POA Manager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Khoi tao cac dich vu
            AssetServiceImpl assetImpl = new AssetServiceImpl();
            ClientServiceImpl clientImpl = new ClientServiceImpl();
            StorageServiceImpl storageImpl = new StorageServiceImpl();
            UserServiceImpl userImpl = new UserServiceImpl();

            // Dua cac dich vu vao CORBA
            org.omg.CORBA.Object ref;

            ref = rootpoa.servant_to_reference(assetImpl);
            AssetService assetServiceRef = AssetServiceHelper.narrow(ref);

            ref = rootpoa.servant_to_reference(clientImpl);
            ClientService clientServiceRef = ClientServiceHelper.narrow(ref);

            ref = rootpoa.servant_to_reference(storageImpl);
            StorageService storageServiceRef = StorageServiceHelper.narrow(ref);

            ref = rootpoa.servant_to_reference(userImpl);
            UserService userServiceRef = UserServiceHelper.narrow(ref);

            // Lien ket voi Naming Service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt namingContext = NamingContextExtHelper.narrow(objRef);

            namingContext.rebind(namingContext.to_name("AssetService"), assetServiceRef);
            namingContext.rebind(namingContext.to_name("ClientService"), clientServiceRef);
            namingContext.rebind(namingContext.to_name("StorageService"), storageServiceRef);
            namingContext.rebind(namingContext.to_name("UserService"), userServiceRef);

            System.out.println("Asset Server dang chay...");

            // Giữ server chạy
            orb.run();
        } catch (Exception e) {
            System.err.println("Loi trong AssetServer: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

