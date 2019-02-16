package genericCheckPointing.util;

/**
 * 
 * @author Abhi
 *
 * class to serialize data types
 */
public class SerializeTypes {
	
	public SerializeTypes()
	{
		
	}

	@Override
	public String toString() {
		return "SerializeTypes [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public String serializeInt(String tagNameIn, int valueIn)
	{
		if(valueIn == 0)
			return "<"+tagNameIn+" xsi:type=\"xsd:int\">"+" "+"</"+tagNameIn+">";
		else
			return "<"+tagNameIn+" xsi:type=\"xsd:int\">"+valueIn+"</"+tagNameIn+">";
		
	}
	
	public String serializeLong(String tagNameIn, long valueIn)
	{
		if(valueIn == 0)
			return "<"+tagNameIn+" xsi:type=\"xsd:long\">"+" "+"</"+tagNameIn+">";
		else
			return "<"+tagNameIn+" xsi:type=\"xsd:long\">"+valueIn+"</"+tagNameIn+">";
		
	}
	
	public String serializeString(String tagNameIn, String valueIn)
	{
		return "<"+tagNameIn+" xsi:type=\"xsd:string\">"+valueIn+"</"+tagNameIn+">";
		
	}
	
	public String serializeBool(String tagNameIn, boolean valueIn)
	{
		return "<"+tagNameIn+" xsi:type=\"xsd:boolean\">"+valueIn+"</"+tagNameIn+">";
		
	}
	
	public String serializeDouble(String tagNameIn, double valueIn)
	{
		if(valueIn == 0)
			return "<"+tagNameIn+" xsi:type=\"xsd:double\">"+" "+"</"+tagNameIn+">";
		else
			return "<"+tagNameIn+" xsi:type=\"xsd:double\">"+valueIn+"</"+tagNameIn+">";
		
	}
	
	public String serializeFloat(String tagNameIn, float valueIn)
	{
		return "<"+tagNameIn+" xsi:type=\"xsd:float\">"+valueIn+"</"+tagNameIn+">";
		
	}
	
	
	public String serializeShort(String tagNameIn, short valueIn)
	{
		return "<"+tagNameIn+" xsi:type=\"xsd:short\">"+valueIn+"</"+tagNameIn+">";
		
	}
	
	public String serializeChar(String tagNameIn, char valueIn)
	{
		return "<"+tagNameIn+" xsi:type=\"xsd:char\">"+valueIn+"</"+tagNameIn+">";
		
	}

		
	
}
