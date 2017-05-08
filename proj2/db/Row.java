package db;

public class Row {
	private int size;
	private String[] data;

	public Row() {
		size = 0;
		data = new String[]();
	}

	public int getSize() {
		return size;
	}

	public void printRow() {
		for (int i = 0; i < size; i++) {
			System.out.print(data[i]);
		}
	}

}