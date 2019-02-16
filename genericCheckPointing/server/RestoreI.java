package genericCheckPointing.server;

import genericCheckPointing.util.SerializableObject;

public interface RestoreI extends StoreRestoreI{

	SerializableObject readObj(String wireFormat,String filename);

}
