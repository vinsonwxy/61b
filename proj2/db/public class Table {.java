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

	public Table(int numRows, int numCols, String[] colNames, String[] colTypes, String[][] tableData) {
		numOfRows = numRows;
		numOfColumns = numCols;
		tableInfo = tableData;
		columnNames = colNames;
		columnTypes = colTypes;
	}

	public void addRow();

	public static void main(String[] args);


}