package genericCheckPointing.util;

/**
 * 
 * @author Abhi
 * 
 * class to deserialize each class type
 *
 */
public class DeserializeComplexType {
	
	public DeserializeComplexType()
	{
		
	}
	
	@Override
	public String toString() {
		return "DeserializeComplexType [getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public String deSerializeCType(String lineIn)
	{
		if(lineIn.contains("complexType"))
		{
			lineIn = lineIn.substring(lineIn.indexOf("\"") + 1);
			lineIn = lineIn.substring(0, lineIn.indexOf("\""));

		}
		return lineIn;
	}


	
}
