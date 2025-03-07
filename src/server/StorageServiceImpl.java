package server;

import AssetManagement.*;
import org.omg.CORBA.*;
import java.util.*;

public class StorageServiceImpl extends StorageServicePOA {
    private ORB orb;
    private final List<String> storage = new ArrayList<>();

    public void setORB(ORB orb) {
        this.orb = orb;
    }

    @Override
    public void addAssetToStorage(String assetId) {
        storage.add(assetId);
        System.out.println("Da them tai san vao kho!");
    }

    @Override
    public void deleteAssetFromStorage(String assetId) {
        if (storage.remove(assetId)) {
            System.out.println("Da xoa tai san khoi kho!");
        } else {
            System.out.println("Tai san khong duoc tim thay!");
        }
    }

    @Override
    public String[] getAllAssetsOnStorage() {
        return storage.toArray(new String[0]);
    }
}
