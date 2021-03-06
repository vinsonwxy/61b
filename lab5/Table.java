package db;

public class Table {
	
	public int numOfRows;
	public int numOfColumns;
	public String[][] tableInfo;
	public String[] columnNames;
	public String[] columnTypes;

	public Table() {
		numOfRows = 0;
		numOfColumns = 0;
		tableInfo = new String[][]();
		columnNames = new String[]();
		columnTypes = new String[]();
	}

	public Table(int numRows, int numCols, String[] colNames, String[] colTypes) {
		numOfRows = numRows;
		numOfColumns = numCols;
		tableInfo = new String[numOfRows][numOfColumns]();
		columnNames = colNames;
		columnTypes = colTypes;
	}

	public Table(String[] titles, int n) {
		numOfRows = n;
		numOfColumns = titles.length();
		tableInfo = new String[n][numOfColumns];
		for (int i = 0; i < numOfColumns; i++) {
			tableInfo[0][i] = titles[i];
		}
	}

	public void addRow();

	public static void main(String[] args);


}