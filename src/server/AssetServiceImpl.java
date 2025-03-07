package server;

import AssetManagement.*;
import org.omg.CORBA.*;
import java.util.*;

public class AssetServiceImpl extends AssetServicePOA {
    private ORB orb;
    private final Map<String, String[]> assets = new HashMap<>();

    public void setORB(ORB orb) {
        this.orb = orb;
    }

    @Override
    public void addAsset(String id, String type, String owner, String status) {
        assets.put(id, new String[]{type, owner, status});
        System.out.println("Da them tai san thanh cong");
    }

    @Override
    public void updateStatus(String id, String newStatus) {
        if (assets.containsKey(id)) {
            assets.get(id)[2] = newStatus;
            System.out.println("Trang thai duoc cap nhat thanh cong!");
        }
        System.out.println("Tai san khong duoc tim thay!");
    }

    @Override
    public String[] getAssetByStatus(String status) {
        return new String[]{assets.entrySet().stream()
                .filter(e -> e.getValue()[2].equals(status))
                .map(e -> e.getKey() + ": " + Arrays.toString(e.getValue()))
                .findFirst().orElse("Khong tai san nao duoc tim thay!")};
    }

    @Override
    public String[] getAssetByOwner(String owner) {
        return new String[]{assets.entrySet().stream()
                .filter(e -> e.getValue()[1].equals(owner))
                .map(e -> e.getKey() + ": " + Arrays.toString(e.getValue()))
                .findFirst().orElse("Khong tai san nao duoc tim thay!")};
    }

    @Override
    public String[] getAssetByType(String type) {
        return new String[]{assets.entrySet().stream()
                .filter(e -> e.getValue()[0].equals(type))
                .map(e -> e.getKey() + ": " + Arrays.toString(e.getValue()))
                .findFirst().orElse("Khong tai san nao duoc tim thay!")};
    }

    @Override
    public void deleteAsset(String id) {
        if (assets.remove(id) != null) {
            System.out.println("Da xoa tai san thanh cong!");
        } else {
            System.out.println("Tai san khong duoc tim thay!");
        }
    }

    @Override
    public String[] getAllAssets() {
        return assets.entrySet().stream()
                .map(e -> e.getKey() + ": " + Arrays.toString(e.getValue()))
                .toArray(String[]::new);
    }
}
