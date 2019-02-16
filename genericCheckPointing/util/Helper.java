package genericCheckPointing.util;

import java.util.Random;
import java.util.Vector;

public class Helper {

	public Helper()
	{
		
	}
	
	@Override
	public String toString() {
		return "Helper [r=" + r + "]";
	}
	
	Random r = new Random();
	
	public void argParser(String mode)
	{
		if(Modes.modeTypes.serdeser.toString().equals(mode) || Modes.modeTypes.deser.toString().equals(mode))
		{
			
		}
		else
		{
			System.err.println("Mode provided is incorrect\n");
			System.exit(0);
		}
	}
	
	public int equalityCheck(Vector<SerializableObject> old,Vector<SerializableObject> newone)
	{
		int count=0;
		for(int i=0;i<old.size();i++) //checking for equality old objects
		{
			SerializableObject s1 = old.get(i);
			boolean bool_val = false;
			for(int j=0;j<newone.size();j++)
			{
				SerializableObject s2 = newone.get(j);
				if(s1.equals(s2))
					bool_val = true;
			}
			if(bool_val== false)
				count++;
			
		}
		
		return count;
	}
	
	public void deserObjectPrint(Vector<SerializableObject> vector_deser)
	{
		for(int i=0;i<vector_deser.size();i++)
		{		
			if(vector_deser.get(i).getClass().toString().contains("MyAllTypesFirst"))
			{ 
				System.out.println("Object of MyAllTypesFirst ");
				MyAllTypesFirst obj2 = new MyAllTypesFirst();
				obj2 = (MyAllTypesFirst)vector_deser.get(i);
				System.out.println("  MyBool is : "+obj2.getMyBool());
				System.out.println("  MyInt is : "+obj2.getMyInt());
				System.out.println("  MyString is : "+obj2.getMyString());
				System.out.println("  MyLong is : "+obj2.getMyLong());
				System.out.println("  MyOtherInt is : "+obj2.getMyOtherInt());
			}
			else if(vector_deser.get(i).getClass().toString().contains("MyAllTypesSecond"))
			{
				System.out.println("Object of MyAllTypesSecond ");
				MyAllTypesSecond obj3 = new MyAllTypesSecond();
				obj3 = (MyAllTypesSecond)vector_deser.get(i);
				System.out.println("  MyCharT is : "+obj3.getMyCharT());
				System.out.println("  MyDoubleT is : "+obj3.getMyDoubleT());
				System.out.println("  MyFloatT is : "+obj3.getMyFloatT());
				System.out.println("  MyOtherDoubleT is : "+obj3.getMyOtherDoubleT());
				System.out.println("  MyShortT is : "+obj3.getMyShortT());
			}
		}
	}
	public int intGenerator()
	{
		//return r.nextInt(100000-11+1)+11;
		return r.nextInt();
	}
	
	public long longGenerator()
	{
		return r.nextLong();
	}
	
	public String stringGenerator()
	{
		return Long.toString( r.nextLong() & Long.MAX_VALUE , 36 );
	}
	
	public boolean boolGenerator()
	{
		return r.nextBoolean();
	}
	
	public float floatGenerator()
	{
		return r.nextFloat();
	}
	
	public short shortGenerator()
	{
		return (short)r.nextInt();
	}
	
	public double doubleGenerator()
	{
		//return 11.0d+r.nextDouble();
		return r.nextDouble();
	}
	
	public char charGenerator()
	{
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return alpha.charAt(r.nextInt(alpha.length()));
	}

	
	
}
