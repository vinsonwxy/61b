package lab9;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class MyHashMap<K, V> implements Map61B<K, V> {
	private ArrayList<Entry> myList;
	private HashSet<K> keySet; 
	private double loadFactor;
	private int n;
	private int m;

	public MyHashMap() {
		m = 5;
		myList = new ArrayList(m);
		loadFactor = 10;
		keySet = new HashSet();
		for (int i = 0; i < m; i++) {
			myList.add(null);
		}
	}

	public MyHashMap(int initialSize) {
		m = initialSize;
		myList = new ArrayList(m);
		loadFactor = 10;
		keySet = new HashSet();
		for (int i = 0; i < m; i++) {
			myList.add(null);
		}
	}

	public MyHashMap(int initialSize, double loadFactor) {
		m = initialSize;
		myList = new ArrayList(m);
		this.loadFactor = loadFactor;
		keySet = new HashSet();
		for (int i = 0; i < m; i++) {
			myList.add(null);
		}
	}

	private class Entry {
		private K key;
		private V val;
		private Entry next;

		public Entry(K key, V val) {
			this.key = key;
			this.val = val;
		}

		public V get(K key) {
			if (this.key == key) {
				return val;
			}
			return next.get(key);
		}

		public void put(K key, V value) {
			Entry ptr = this;
			if (this.key == key) {
				this.val = value;
			}
			while (ptr.next != null) {
				ptr = ptr.next;
				if (ptr.key == key) {
					ptr.val = value;
					return;
				}
			}
			Entry e = new Entry(key, value);
			ptr.next = e;
		}
	}

	/** Removes all of the mappings from this map. */
    @Override
    public void clear() {
    	myList = null;
    	keySet = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
    	return keySet.contains(key);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
    @Override
    public V get(K key) {
    	int i = hash(key);
    	return myList.get(i).get(key);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
    	return keySet.size();
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
    	if (n >= m * loadFactor) {
    		resize(2 * m);
    	}
    	int i = hash(key);
    	if (!keySet.contains(key)) {
    		n += 1;
    		keySet.add(key);
    	}
    	if (myList.get(i) == null) {
    		Entry e = new Entry(key, value);
    		myList.add(i, e);
    	} else {
    		myList.get(i).put(key, value);
    	}
    }

    private void resize(int chains) {
        MyHashMap<K, V> temp = new MyHashMap(chains);
        for (int i = 0; i < m; i++) {
        	Entry p = myList.get(i);
            while (p != null) {
                temp.put(p.key, p.val);
                p = p.next;
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.myList = temp.myList;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

	@Override
	public Iterator<K> iterator() {
		return keySet.iterator();
	}

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
    	return keySet;
    }   

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an 
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
    	throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
    	throw new UnsupportedOperationException();
    }
}