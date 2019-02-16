package genericCheckPointing.util;

/**
 * 
 * @author Abhi
 *
 * class to deserialize each class type
 */
public class DeserializeTypes {

	public DeserializeTypes()
	{
		
	}
	
	@Override
	public String toString() {
		return "DeserializeTypes [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public int deserializeInt(String tagNameIn)
	{	
		return Integer.parseInt(tagNameIn);
	}
	
	public long deserializeLong(String tagNameIn)
	{		
		return Long.parseLong(tagNameIn);	
	}
	
	public String deserializeString(String tagNameIn)
	{
		return tagNameIn;		
	}
	
	public boolean deserializeBool(String tagNameIn)
	{
		return Boolean.parseBoolean(tagNameIn);
	}
	
	public double deserializeDouble(String tagNameIn)
	{
		return Double.parseDouble(tagNameIn);
	}
	
	public float deserializeFloat(String tagNameIn)
	{
		return Float.parseFloat(tagNameIn);
	}
	
	
	public short deserializeShort(String tagNameIn)
	{
		return Short.parseShort(tagNameIn);
	}
	
	public char deserializeChar(String tagNameIn)
	{
		return tagNameIn.charAt(0);
	}

	
	
}
