package genericCheckPointing.util;

/**
 * 
 * @author Abhi
 *
 */
public class MyAllTypesSecond extends SerializableObject{

	private float myFloatT;
	private short myShortT;
	private double myDoubleT;
	private double myOtherDoubleT;
	private char myCharT;
	
	public MyAllTypesSecond()
	{
//		setMyFloatT(1);
//		setMyShortT((short)1);
//		setMyDoubleT(1.0);
//		setMyOtherDoubleT(2.0);
//		setMyCharT('A');
	}
	public MyAllTypesSecond(float myFloatT, short myShortT, double myDoubleT, double myOtherDoubleT, char myCharT)
	{
		setMyFloatT(myFloatT);
		setMyShortT(myShortT);
		setMyDoubleT(myDoubleT);
		setMyOtherDoubleT(myOtherDoubleT);
		setMyCharT(myCharT);
	}
	
	@Override
	public String toString() {
		return "MyAllTypesSecond [myFloatT=" + myFloatT + ", myShortT="
				+ myShortT + ", myDoubleT=" + myDoubleT + ", myOtherDoubleT="
				+ myOtherDoubleT + ", myCharT=" + myCharT + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharT;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(myFloatT);
		temp = Double.doubleToLongBits(myOtherDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myShortT;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		boolean returnVal = false;
		if(obj instanceof MyAllTypesSecond)
		{
			MyAllTypesSecond s = (MyAllTypesSecond)obj;
			returnVal = (s.getMyCharT()== getMyCharT())&& (s.getMyDoubleT()== getMyDoubleT())&& (s.getMyFloatT()==getMyFloatT())
					&&(s.getMyOtherDoubleT()==getMyOtherDoubleT())&& (s.getMyShortT()==getMyShortT());
		}
		return returnVal;
	}
	
	public float getMyFloatT() {
		return myFloatT;
	}
	public void setMyFloatT(float myFloatT) {
		this.myFloatT = myFloatT;
	}
	public short getMyShortT() {
		return myShortT;
	}
	public void setMyShortT(short myShortT) {
		this.myShortT = myShortT;
	}
	public double getMyDoubleT() {
		return myDoubleT;
	}
	public void setMyDoubleT(double myDoubleT) {
		this.myDoubleT = myDoubleT;
	}
	public double getMyOtherDoubleT() {
		return myOtherDoubleT;
	}
	public void setMyOtherDoubleT(double myOtherDoubleT) {
		this.myOtherDoubleT = myOtherDoubleT;
	}
	public char getMyCharT() {
		return myCharT;
	}
	public void setMyCharT(char myCharT) {
		this.myCharT = myCharT;
	}
	
	
	
}
