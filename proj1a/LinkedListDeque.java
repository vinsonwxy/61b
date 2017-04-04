public class LinkedListDeque<Item> {
	private class StuffNode {
		public Item item;
		public StuffNode prev;
		public StuffNode next;

		public StuffNode(Item i, StuffNode p, StuffNode n) {
			item = i;
			prev = p;
			next = n;
		}
	} 

	private StuffNode sentinel;
	private int size;

	public LinkedListDeque() {
		sentinel = new StuffNode(null, sentinel, sentinel);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		size = 0;
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(Item i) {
 		sentinel.next = new StuffNode(i, sentinel, sentinel.next);
 		sentinel.next.next.prev = sentinel.next;
 		size += 1;
 	}

 	/** Adds an item to the end of the list. */
 	public void addLast(Item i) {
 		sentinel.prev = new StuffNode(i, sentinel.prev, sentinel);
 		sentinel.prev.prev.next = sentinel.prev;
 		size += 1;
 	}

 	public int size() {
 		return size;
 	}

	public boolean isEmpty(){
		return size == 0;
	}

	public void printDeque(){
		StuffNode curr = sentinel.next;
		int i = 0;
		while (i < size){
			System.out.print(curr.item);
			curr = curr.next;
			i++;
		}
	}

	public Item removeFirst(){
		Item first = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		if (size > 0) {
			size -= 1;
		}
		return first;
	}

	public Item removeLast() {
		Item last = sentinel.prev.item;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		if (size > 0) {
			size -= 1;
		}
		return last;
	}

	public Item get(int index) {
		int i = 0;
		StuffNode curr = sentinel.next;
		while (i < index) {
			curr = curr.next;
			i++;
		}
		return curr.item;
	}

	private Item getRecursiveHelper(int index, StuffNode curr) {
		if (index == 0) {
			return curr.item;
		}
		return getRecursiveHelper(index - 1, curr.next);
	}

	public Item getRecursive(int index) {
		StuffNode curr = sentinel.next;
		return getRecursiveHelper(index, curr);
	}

	// public static void main(String[] args){
	// 	LinkedListDeque<String> str = new LinkedListDeque<String> ();
	// 	System.out.println(str.sentinel.item);
	// 	str.addFirst("cool");
	// }

}