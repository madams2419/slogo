package backend;

public class BiIndex<V> extends BiMap<Integer, V> {
	
	public BiIndex(V[] values) {
		super();
		for(int i = 0; i < values.length; i++) {
			put(new Integer(i), values[i]);
		}
	}
	
}
