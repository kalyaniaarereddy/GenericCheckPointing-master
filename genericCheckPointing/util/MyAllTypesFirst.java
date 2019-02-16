package genericCheckPointing.util;

/**
 * 
 * @author Abhi
 *
 */
public class MyAllTypesFirst extends SerializableObject{

	private int myInt;
	private long myLong;
	private String myString;
	private boolean myBool;
	private int myOtherInt;
	
	public MyAllTypesFirst()
	{
//		setMyInt(1);
//		setMyLong(1);
//		setMyString("A");
//		setMyBool(true);
//		setMyOtherInt(2);
	}
	public MyAllTypesFirst(int myInt, long myLong, String myString, boolean myBool, int myOtherInt)
	{
		setMyInt(myInt);
		setMyLong(myLong);
		setMyString(myString);
		setMyBool(myBool);
		setMyOtherInt(myOtherInt);
		
	}
	
	@Override
	public String toString() {
		return "MyAllTypesFirst [myInt=" + myInt + ", myLong=" + myLong
				+ ", myString=" + myString + ", myBool=" + myBool
				+ ", myOtherInt=" + myOtherInt + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (myBool ? 1231 : 1237);
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result + myOtherInt;
		result = prime * result
				+ ((myString == null) ? 0 : myString.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		boolean returnVal = false;
		if(obj instanceof MyAllTypesFirst)
		{
			MyAllTypesFirst s = (MyAllTypesFirst)obj;
			returnVal = (s.getMyInt()== getMyInt())&& (s.getMyBool()== getMyBool())&& (s.getMyLong()==getMyLong())&&
					(s.getMyOtherInt()==getMyOtherInt())&& (s.getMyString().equals(getMyString()));
		}
		return returnVal;
	}
	
	public int getMyInt() {
		return myInt;
	}
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	public long getMyLong() {
		return myLong;
	}
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
	public boolean isMyBool() {
		return myBool;
	}
	public void setMyBool(boolean myBool) {
		this.myBool = myBool;
	}
	public boolean getMyBool()
	{
		return myBool;
	}
	public int getMyOtherInt() {
		return myOtherInt;
	}
	public void setMyOtherInt(int myOtherInt) {
		this.myOtherInt = myOtherInt;
	}
	
	
}
