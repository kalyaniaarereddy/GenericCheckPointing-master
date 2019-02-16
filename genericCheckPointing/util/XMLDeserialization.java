package genericCheckPointing.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 
 * @author Abhi
 *
 *	class to deserialize--using strategy pattern
 */
public class XMLDeserialization implements SerStrategy{

	HashMap<String,String> hm = new HashMap<String,String>();
	public static long offset;
	
	public XMLDeserialization()
	{

	}
	
	@Override
	public String toString() {
		return "XMLDeserialization [hm=" + hm + "]";
	}
	
	
	@Override
	public void processInput(SerializableObject sObject,RandomAccessFile fileIn) {
		
		DeserializeComplexType dct = null;
		DeserializeTypes dt = new DeserializeTypes();
		String cType = null;
		String str = null;
		boolean b = false;
		Object o = null;
		try {
			Class c = null;
			int i=0;		
			fileIn.seek(offset);
			while((str = fileIn.readLine())!=null)
			{
				//System.out.println("file being read is "+str);
				if(str.contains("complexType"))
				{
					dct = new DeserializeComplexType();
					cType = dct.deSerializeCType(str);
					if(cType.contains("MyAllTypesFirst"))
					{
						//sObject = new MyAllTypesFirst();
						if(sObject.toString().contains("MyAllTypesFirst"))
						i = 1;
					}
					else 
					{
						//sObject = new MyAllTypesSecond();
						if(sObject.toString().contains("MyAllTypesSecond"))
						i = 1;
					}
					try {
						c = Class.forName(cType); //creates an instance of required class
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				else if(str.contains("/DPSerialization"))
				{
					i=0;
					offset =  fileIn.getFilePointer();
					return;
				}
				else
				{
					if( i== 1)
					{
						//gives a string as either int/float/string etc
						String dataTypeS = str.substring(str.indexOf("\"") + 1);
						dataTypeS = dataTypeS.substring(0, dataTypeS.indexOf("\""));
						String[] str2 = dataTypeS.split(":"); 
						dataTypeS = str2[1];
						//System.out.println("data Type is "+dataTypeS);
						
						//gets the setter method name
						String str1 = str.substring(str.indexOf("<") + 1);
						str1 = str1.substring(0, str1.indexOf(" "));
						String methodName = str1.substring(0,1).toUpperCase()+str1.substring(1,str1.length());
						methodName = "set"+methodName;
						//System.out.println("method name is "+methodName);
						
						//gets the value in string format
						String value = str.substring(str.indexOf(">") + 1);
						value = value.substring(0, value.indexOf("<"));
											
						//System.out.println("value is "+value);
						
						
						Method method = null;
						
					      try
					      {
					    	  if(dataTypeS.equals("int"))
					    	  {
					    		  method = c.getMethod(methodName,int.class);
					    		  if(value.equals(" "))
					    		  {
					    			  
					    		  }
					    		  else
					    		  {
					    			  o = method.invoke(sObject, dt.deserializeInt(value));
					    		  }
					    		  
					    	  }
					    	  else if(dataTypeS.equals("long"))
					    	  {
					    		  method = c.getMethod(methodName,long.class);
					    		  if(value.equals(" "))
					    		  {
					    			  
					    		  }
					    		  else
					    		  {
					    			  o = method.invoke(sObject, dt.deserializeLong(value));
					    		  }
					    	  }
					    	  else if(dataTypeS.equals("string"))
					    	  {
					    		  method = c.getMethod(methodName,String.class);
					    		  o = method.invoke(sObject, dt.deserializeString(value));
					    	  }
					    	  else if(dataTypeS.equals("boolean"))
					    	  {
					    		  method = c.getMethod(methodName,boolean.class);
					    		  o = method.invoke(sObject, dt.deserializeBool(value));
					    	  }
					    	  else if(dataTypeS.equals("float"))
					    	  {
					    		  method = c.getMethod(methodName,float.class);
					    		  o = method.invoke(sObject, dt.deserializeFloat(value));
					    	  }
					    	  else if(dataTypeS.equals("double"))
					    	  {
					    		  method = c.getMethod(methodName,double.class);
					    		  if(value.equals(" "))
					    		  {
					    			  
					    		  }
					    		  else
					    		  {
					    			  o = method.invoke(sObject, dt.deserializeDouble(value));
					    		  }
					    	  }
					    	  else if(dataTypeS.equals("short"))
					    	  {
					    		  method = c.getMethod(methodName,short.class);
					    		  o = method.invoke(sObject, dt.deserializeShort(value));
					    	  }
					    	  else if(dataTypeS.equals("char"))
					    	  {
					    		  method = c.getMethod(methodName,char.class);
					    		  o = method.invoke(sObject, dt.deserializeChar(value));
					    	  }
					         
					      }
					      catch (NoSuchMethodException e)
					      {
					         System.out.println("No such method: " + e.getMessage());
					         System.exit(1);
					      }
					      catch (IllegalAccessException e)
					      {
					         System.out.println("Illegal access: " + e.getMessage());
					         System.exit(1);
					      }
					      catch (InvocationTargetException e)
					      {
					         System.out.println("Invocation target exception: " + e.getMessage());
					         System.out.println("Exception: " + e.getTargetException().getMessage());
					         System.exit(1);
					      }
					      
					}
					else
						continue;
					
				} 
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	

}
