package AssetManagement;


/**
* AssetManagement/StorageServiceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from src/idl/asset_management.idl
* Friday, March 7, 2025 10:20:05 AM ICT
*/

public interface StorageServiceOperations 
{
  void addAssetToStorage (String id);
  void deleteAssetFromStorage (String id);
  String[] getAllAssetsOnStorage ();
} // interface StorageServiceOperations
