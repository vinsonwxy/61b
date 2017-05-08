package hw2;                       

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[][] openTable;
	private int numOpen;
	private WeightedQuickUnionUF uf1;
	private WeightedQuickUnionUF uf2;
	private int N;

	public Percolation(int N){
		if (N <= 0) {
			throw new java.lang.IllegalArgumentException();
		}
		this.N = N;
		numOpen = 0;
		uf1 = new WeightedQuickUnionUF(N * N + 1);
		uf2 = new WeightedQuickUnionUF(N * N + 2);
		openTable = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				openTable[i][j] = false;
				if (i == 0) {
					uf1.union(N * N, xyTo1D(i, j));
					uf2.union(N * N, xyTo1D(i, j));
				}
				if (i == N - 1) {
					uf2.union(N * N + 1, xyTo1D(i, j));
				}
			}
		}
	}

	public void open(int row, int col) {
		if (row >= N || row < 0 || col >= N || col < 0) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		if (openTable[row][col] == false) {
			numOpen += 1;
		}
		openTable[row][col] = true;
		if (row != 0 && isOpen(row - 1, col)) {
			uf1.union(xyTo1D(row, col), xyTo1D(row - 1, col));
			uf2.union(xyTo1D(row, col), xyTo1D(row - 1, col));
		} 
		if (row != N - 1 && isOpen(row + 1, col)) {
			uf1.union(xyTo1D(row, col), xyTo1D(row + 1, col));
			uf2.union(xyTo1D(row, col), xyTo1D(row + 1, col));
		} 
		if (col != 0 && isOpen(row, col - 1)) {
			uf1.union(xyTo1D(row, col), xyTo1D(row, col - 1));
			uf2.union(xyTo1D(row, col), xyTo1D(row, col - 1));
		} 
		if (col != N - 1 && isOpen(row, col + 1)) {
			uf1.union(xyTo1D(row, col), xyTo1D(row, col + 1));
			uf2.union(xyTo1D(row, col), xyTo1D(row, col + 1));
		} 
	}

	public boolean isOpen(int row, int col) {
		if (row >= N || row < 0 || col >= N || col < 0) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		return openTable[row][col];
	}

	public int xyTo1D(int row, int col) {
		return row * N + col;
	}

	public boolean isFull(int row, int col) {
		if (row >= N || row < 0 || col >= N || col < 0) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		return isOpen(row, col) && uf1.connected(xyTo1D(row, col), N * N);
	}

	public int numberOfOpenSites() {
		return numOpen;
	}

	public boolean percolates(){
		return uf2.connected(N * N + 1, N * N);
	}

	public static void main(String[] args) {

	}
}                       
