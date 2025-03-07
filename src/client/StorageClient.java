package client;

import AssetManagement.StorageService;
import AssetManagement.StorageServiceHelper;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class StorageClient {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            StorageService storageService = StorageServiceHelper.narrow(ncRef.resolve_str("StorageService"));

            System.out.println("Them tai san vao kho:");
            storageService.addAssetToStorage("A100");

            System.out.println("Xoa tai san khoi kho:");
            storageService.deleteAssetFromStorage("A100");

            System.out.println("Danh sach tai san trong kho:");
            String[] assetsInStorage = storageService.getAllAssetsOnStorage();
            for (String asset : assetsInStorage) {
                System.out.println(asset);
            }

        } catch (Exception e) {
            System.err.println("Loi trong StorageClient: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

