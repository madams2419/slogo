package backend;

import java.util.HashMap;

public class BiMap<K, V> {

	private HashMap<K, V> directMap;
	private HashMap<V, K> inverseMap;

	public BiMap() {
		directMap = new HashMap<>();
		inverseMap = new HashMap<>();
	}

	public void put(K key, V value) {
		if(directMap.containsKey(key)) {
			V oldVal = directMap.get(key);
			inverseMap.remove(oldVal);
		}
		directMap.put(key, value);
		inverseMap.put(value, key);
	}

	public K getKey(V value) {
		return inverseMap.get(value);
	}

	public V getValue(K key) {
		return directMap.get(key);
	}

}


