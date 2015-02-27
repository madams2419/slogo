package backend;

public class StringPair {
	private String property;
	private String value;

	public StringPair(String prop, String val) {
		property = prop;
		value = val;
	}
	
	public String getProp() {
		return property;
	}
	
	public String getVal() { 
		return value;
	}
}