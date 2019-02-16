package genericCheckPointing.driver;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import genericCheckPointing.server.RestoreI;
import genericCheckPointing.server.StoreI;
import genericCheckPointing.server.StoreRestoreI;
import genericCheckPointing.util.Helper;
import genericCheckPointing.util.Modes;
import genericCheckPointing.util.MyAllTypesFirst;
import genericCheckPointing.util.MyAllTypesSecond;
import genericCheckPointing.util.ProxyCreator;
import genericCheckPointing.util.SerializableObject;
import genericCheckPointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {

	/**
	 * @author Abhi
	 */
	public static HashMap<String,SerializableObject> hm = new HashMap<String,SerializableObject>();
	public static ArrayList<SerializableObject> objs = new ArrayList<SerializableObject>();
	
	@Override
	public String toString() {
		return "Driver [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	public static void main(String[] args) {
		
		
		if(args.length!=3)
		{
			System.err.println("Number of arguments provided is incorrect\n");
			System.exit(0);
		}
		
		String mode = args[0];
		int N =0 ;
		try
		{
		N = Integer.parseInt(args[1]);	
		}
		catch(NumberFormatException e)
		{
			System.out.println("The second argument should be a number");
			System.exit(0);
		}
		String fileName = args[2];
		
		Helper helper = new Helper();
		helper.argParser(mode);
		
		
		ProxyCreator pc = new ProxyCreator();
		
		InvocationHandler storeRestoreHandler = new StoreRestoreHandler();
		
		
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
								   new Class[] {
										   StoreI.class, RestoreI.class
								   }, 
								   storeRestoreHandler
									);
			
		
		
		MyAllTypesFirst myFirst;
		MyAllTypesSecond  mySecond;

		if(Modes.modeTypes.serdeser.toString().equals(mode))
		{
			Vector<SerializableObject> vector_old = new Vector<SerializableObject>(N+N);
			Vector<SerializableObject> vector_new = new Vector<SerializableObject>(N+N);

			
			for (int i=0; i<N; i++) 
			{
			    myFirst = new MyAllTypesFirst(helper.intGenerator(), helper.longGenerator(), helper.stringGenerator(), helper.boolGenerator(), helper.intGenerator());
			    mySecond = new MyAllTypesSecond(helper.floatGenerator(),helper.shortGenerator() ,helper.doubleGenerator(),helper.doubleGenerator(),helper.charGenerator());
				//myFirst = new MyAllTypesFirst(2,5,"ABC",false, 6);
			    //mySecond = new MyAllTypesSecond(12.6f,(short)6 ,13.3d,14.4d,'C');
			    vector_old.addElement(myFirst);
			    vector_old.addElement(mySecond);
			    
			    ((StoreI) cpointRef).writeObj(myFirst,1,"XML",fileName);
			    objs.add(myFirst);
			    ((StoreI) cpointRef).writeObj(mySecond,2, "XML",fileName);
			    objs.add(mySecond);

			}

			SerializableObject myRecordRet;
	
			for (int j=0; j<2*N; j++) {
	
				hm.put("XML",objs.get(j));
			    myRecordRet = (SerializableObject)((RestoreI) cpointRef).readObj("XML",fileName);
			    vector_new.addElement(myRecordRet);
			 
			}
			
			int count = helper.equalityCheck(vector_old, vector_new);
			System.out.println("total no of object mismatches are "+count);
					
		}
		else if(Modes.modeTypes.deser.toString().equals(mode))
		{
			Vector<SerializableObject> vector_deser = new Vector<SerializableObject>(N);
			SerializableObject obj_new = null;
			
			
			for(int i=0;i< N;i++)
			{
				MyAllTypesFirst first_new;
				MyAllTypesSecond second_new;
				if(i%2 == 0)
					obj_new = new MyAllTypesFirst();
				else
					obj_new = new MyAllTypesSecond();
				hm.put("XML",obj_new);
				if(i%2 ==0)
					 first_new =(MyAllTypesFirst) ((RestoreI)cpointRef).readObj("XML", fileName);
				else
					 second_new = (MyAllTypesSecond)((RestoreI)cpointRef).readObj("XML", fileName);
				vector_deser.add(obj_new);
			}

			
			helper.deserObjectPrint(vector_deser);

		}
			

	}
	
	
}
