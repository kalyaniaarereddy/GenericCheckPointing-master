package genericCheckPointing.xmlStoreRestore;

import genericCheckPointing.driver.Driver;
import genericCheckPointing.util.SerStrategy;
import genericCheckPointing.util.SerializableObject;
import genericCheckPointing.util.XMLDeserialization;
import genericCheckPointing.util.XMLSerialization;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @author Abhi
 * 
 * 	class with method invoke that will be called when a method is called using proxy handler
 */
public class StoreRestoreHandler implements InvocationHandler{
	
	public StoreRestoreHandler()
	{
		
	}
	
	@Override
	public String toString() {
		return "StoreRestoreHandler [raf=" + raf + "]";
	}

	
RandomAccessFile raf = null;
public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
{
	
	Object o = null;
	if(m.getName().toString().equals("writeObj"))
	{
		if(args[2].equals("XML"))
		{
			openFile(args[3].toString());
			serializeData((SerializableObject)args[0],args[3].toString(),new XMLSerialization());
			closeFile(raf);
		}
	}

	else if(m.getName().toString().equals("readObj"))
	{
		if(args[0].equals("XML"))
		{
			openFile(args[1].toString());
			serializeData(Driver.hm.get("XML"),args[1].toString(),new XMLDeserialization());
			closeFile(raf);
			return Driver.hm.get("XML");
		}
		
	}
	    
	return null;
}

   public void serializeData(SerializableObject sObject,String fileIn, SerStrategy sStrategy) {
              
	  
	   if(sStrategy.toString().contains("XMLDeserialization"))
	   {	   
		   sStrategy.processInput(sObject,raf);
	   }
	   else if(sStrategy.toString().contains("XMLSerialization"))
	   {	   
		    sStrategy.processInput(sObject,raf);
	   }
	   
	   
    }
   
   public void openFile(String fileIn)
   {
	   
	   try 
	   {
		   File f = new File(fileIn);
		   raf = new RandomAccessFile(f, "rw");
	   } 
	   catch (FileNotFoundException e) 
	   {
		e.printStackTrace();
	   }
   
   }
	   
   
   public void closeFile(RandomAccessFile rafIn)
   {
			try {
				if(raf!=null)
					raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
   }


}
