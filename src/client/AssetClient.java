package client;

import AssetManagement.AssetService;
import AssetManagement.AssetServiceHelper;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class AssetClient {
    public static void main(String[] args) {
        try {
            // Thiet lap ORB
            ORB orb = ORB.init(args, null);

            // Lay tham chieu tu Naming Service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Lay AssetService tu CORBA
            AssetService assetService = AssetServiceHelper.narrow(ncRef.resolve_str("AssetService"));

            // Goi thu mot so ham tu AssetService
            System.out.println("Goi getAllAsset:");
            String[] assets = assetService.getAllAssets();
            for (String asset : assets) {
                System.out.println(asset);
            }

            System.out.println("\nThem tai san moi:");
            assetService.addAsset("A100", "Laptop", "User1", "Available");

            System.out.println("Cap nhat trang thai tai khoan:");
            assetService.updateStatus("A100", "In Use");

        } catch (Exception e) {
            System.err.println("Loi trong AssetClient: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
