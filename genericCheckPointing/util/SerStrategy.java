package genericCheckPointing.util;

import java.io.RandomAccessFile;



public interface SerStrategy {
	
	void processInput(SerializableObject sObject,RandomAccessFile raf);
}
