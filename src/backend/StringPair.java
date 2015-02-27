package backend;

public class StringPair {
	private String property;
	private String value;

	public StringPair(String prop, String val) {
		property = prop;
		value = val;
	}
	
	public String getProperty() {
		return property;
	}
	
	public String getValue() { 
		return value;
	}
}