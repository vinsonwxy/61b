public class Table {
	
	public int numOfRows;
	public int numOfColumns;
	public String[][] t;

	public Table(String[] titles, int n) {
		numOfRows = n;
		numOfColumns = titles.length();
		t = new String[n][numOfColumns];
		for (int i = 0; i < numOfColumns; i++) {
			t[0][i] = titles[i];
		}
	}

	public void addRow();

	public static void main(String[] args);


}