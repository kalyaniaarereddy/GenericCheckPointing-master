package genericCheckPointing.util;

/**
 * 
 * @author Abhi
 *
 * class to serialize complex types
 */
public class SerializeComplexType {

	public SerializeComplexType()
	{
		
	}
	
	@Override
	public String toString() {
		return "SerializeComplexType [getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public String serializeCType(String strIn)
	{
		return "<complexType xsi:type=\""+strIn+"\">";
	}
	
}
