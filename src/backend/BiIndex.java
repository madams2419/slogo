package backend;

public class BiIndex<V> extends BiMap<Integer, V> {

	public BiIndex() {
		super();
	}

	public BiIndex(V[] initValues) {
		this();
		for(int i = 0; i < initValues.length; i++) {
			put(new Integer(i), initValues[i]);
		}
	}

}
