package genericCheckPointing.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author Abhi
 *
 *	class to serialize -- uses strategy pattern
 */
public class XMLSerialization implements SerStrategy{
	
	public XMLSerialization()
	{
		
	}


	@Override
	public String toString() {
		return "XMLSerialization [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	@Override
	public void processInput(SerializableObject sObject,RandomAccessFile raf) {
		
		
			try {
				raf.seek(raf.length());
				raf.writeBytes("<DPSerialization>\n");
			
				Class cls = sObject.getClass();
				Field[] fieldlist = cls.getDeclaredFields();
				String fieldName = null;
			
			
				SerializeComplexType Scomplex = new SerializeComplexType();
				SerializeTypes Stypes = Stypes = new SerializeTypes();
				String returnType = null;
				for (int i = 0; i < fieldlist.length; i++) {
					Field fld = fieldlist[i];

					if(fld.getDeclaringClass().toString().contains("genericCheckPointing.util.MyAllTypesFirst"))
					{
						String returnScomplex = Scomplex.serializeCType("genericCheckPointing.util.MyAllTypesFirst");
						if(i==0)
						{
							raf.seek(raf.length());
							raf.writeBytes(" "+returnScomplex+"\n");
						}
						
						if(fld.getType()==int.class || fld.getType()== long.class || fld.getType()== String.class ||fld.getType()== boolean.class)
						{
							fieldName = fld.getName().toString().substring(0,1).toUpperCase()+fld.getName().toString().substring(1,fld.getName().toString().length());
						}

					}
					else if(fld.getDeclaringClass().toString().contains("genericCheckPointing.util.MyAllTypesSecond"))
					{
						String returnScomplex = Scomplex.serializeCType("genericCheckPointing.util.MyAllTypesSecond");
						if(i==0)
						{
							raf.seek(raf.length());
							raf.writeBytes(" "+returnScomplex+"\n");
						}
						
						if(fld.getType()== float.class || fld.getType()== short.class || fld.getType()== double.class ||fld.getType()== char.class)
						{
							fieldName = fld.getName().toString().substring(0,1).toUpperCase()+fld.getName().toString().substring(1,fld.getName().toString().length());
						}

					}
				
		        
				String getterMethod = "get"+fieldName;
		        
		        
		        try {
					Method getterMethod2 = cls.getMethod(getterMethod);
					Object invokeRet = getterMethod2.invoke(sObject);
					Object retobj = getterMethod2.invoke(sObject);
					if(fld.getType()== int.class)
					{
						Integer retval = (Integer)retobj;
						if(retval.intValue()<10)
							returnType = Stypes.serializeInt(fld.getName().toString(), 0);
						else
							returnType = Stypes.serializeInt(fld.getName().toString(), retval.intValue());
						raf.seek(raf.length());
						raf.writeBytes("  "+returnType+"\n");
					}
					else if(fld.getType()== long.class)
					{
						Long retval = (Long)retobj;
						if(retval.longValue() <10)
							returnType = Stypes.serializeLong(fld.getName().toString(), 0);
						else
							returnType = Stypes.serializeLong(fld.getName().toString(), retval.longValue());
						raf.seek(raf.length());
						raf.writeBytes("  "+returnType+"\n");
					}
					else if(fld.getType()== String.class)
					{
						String retval = (String)retobj;
						returnType = Stypes.serializeString(fld.getName().toString(), retval.toString());
						raf.seek(raf.length());
						raf.writeBytes("  "+returnType+"\n");
					}
					else if(fld.getType()== boolean.class)
					{
						Boolean retval = (Boolean)retobj;
						returnType = Stypes.serializeBool(fld.getName().toString(), retval.booleanValue());
						raf.seek(raf.length());
						raf.writeBytes("  "+returnType+"\n");
					}
					else if(fld.getType()== float.class)
					{
						Float retval = (Float)retobj;
						returnType = Stypes.serializeFloat(fld.getName().toString(), retval.floatValue());
						raf.seek(raf.length());
						raf.writeBytes("  "+returnType+"\n");
					}
					else if(fld.getType()== short.class)
					{
						Short retval = (Short)retobj;
						returnType = Stypes.serializeShort(fld.getName().toString(), retval.shortValue());
						raf.seek(raf.length());
						raf.writeBytes("  "+returnType+"\n");
					}
					else if(fld.getType()== double.class)
					{
						Double retval = (Double)retobj;
						if(retval.doubleValue() < 10)
							returnType = Stypes.serializeDouble(fld.getName().toString(), 0);
						else
							returnType = Stypes.serializeDouble(fld.getName().toString(), retval.doubleValue());
						raf.seek(raf.length());
						raf.writeBytes("  "+returnType+"\n");
					}
					else if(fld.getType()== char.class)
					{
						Character retval = (Character)retobj;
						returnType = Stypes.serializeChar(fld.getName().toString(), retval.charValue());
						raf.seek(raf.length());
						raf.writeBytes("  "+returnType+"\n");
					}
					
					
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					
					e.printStackTrace();
				}

			}
			raf.seek(raf.length());
			raf.writeBytes("</DPSerialization>\n");
			
			
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			//return null;
		
	      	
	   }

}
