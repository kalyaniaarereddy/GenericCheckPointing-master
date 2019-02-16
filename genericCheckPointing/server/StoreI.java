package genericCheckPointing.server;

import genericCheckPointing.util.MyAllTypesFirst;
import genericCheckPointing.util.MyAllTypesSecond;

public interface StoreI extends StoreRestoreI{
	
	void writeObj(MyAllTypesFirst aRecord, int authID, String wireFormat ,String filename);
    void writeObj(MyAllTypesSecond bRecord, int authID, String wireFormat, String filename);
}
