public class ArrayDeque<Item> {
	private Item[] items;
	private int size;
	private int nextFirst;
	private int nextLast;

	public ArrayDeque() {
		items = (Item[]) new Object[8];
		size = 0;
		nextLast = 0;
		nextFirst = 7;
	}

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        int start = (nextFirst + 1) % items.length;
        System.arraycopy(items, start, a, 0, size - start);
        System.arraycopy(items, 0, a, size - start, start);
        items = a;
    }

    public void addFirst(Item i) {
        if (size == items.length) {
            resize(size * 2);
            nextFirst = items.length - 1;
            nextLast = 0;
        }

        items[nextFirst] = i;
        nextFirst = (nextFirst + items.length - 1) % items.length;
        size = size + 1;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item i) {
        if (size == items.length) {
            resize(size * 2);
            nextFirst = items.length - 1;
            nextLast = 0;
        }

        items[nextLast] = i;
        nextLast = (nextLast + 1) % items.length;
        size = size + 1;
    }

    public boolean isEmpty() {
    	return size == 0;
    }

    public void printDeque() {
    	for (int i = 0; i < size; i++) {
    		System.out.print(items[(i + nextFirst + 1) % items.length]);
    	}
    }

    /** Gets the ith item in the list (0 is the front). */
    public Item get(int index) {
    	if (index > size - 1){
    		return null;
    	}
        return items[(index + nextFirst + 1) % items.length];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public Item removeFirst() {
    	int first = (nextFirst + 1) % items.length;
        Item x = items[first];
        items[first] = null;
        size = size - 1;
        nextFirst = first;
        if (size > 8 && size < items.length/4) {
        	resize(items.length/2);
        	nextLast = 0;
        	nextFirst = items.length - 1;
        }
        return x;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
    	int last = (nextLast + items.length - 1) % items.length;
        Item x = items[last];
        items[last] = null;
        size = size - 1;
        nextLast = last;
        if (size > 8 && size < items.length/4) {
        	resize(items.length/2);
        	nextLast = 0;
        	nextFirst = items.length - 1;
        }
        return x;
    }

    // public static void main(String[] args) {
    // 	ArrayDeque<Integer> a = new ArrayDeque<Integer>();
    // 	a.addFirst(3);
    // 	a.addFirst(1);
    // 	a.addLast(4);
    // 	a.printDeque();
    // }


}