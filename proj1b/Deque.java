public interface Deque<Item> {

	public void addFirst(Item x);

	public void addLast(Item x);

	public boolean isEmpty();

	public Item removeFirst();

	public Item removeLast();

	public int size();

	public void printDeque();

	public Item get(int index);

}