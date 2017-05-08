package hw3.puzzle;

import java.util.Queue;
import java.util.ArrayDeque;

public class Board implements WorldState {
    private int size;
    private int[][] mytiles;

    public Board(int[][] tiles) {
        size = tiles.length;
        mytiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mytiles[i][j] = tiles[i][j];
            }
        }

    }

    public int tileAt(int i, int j) {
        if (i >= 0 && j >= 0 && i < size && j < size) {
            return mytiles[i][j];
        } else {
            throw new java.lang.IndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new ArrayDeque<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == 0) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = 0;
                    Board neighbor = new Board(ili1li1);
                    neighbors.add(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = 0;
                }
            }
        }
        return neighbors;
    }

    public int hamming() {
        int h = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (mytiles[i][j] == (i * size + j + 1) % (size * size)) {
                    h += 1;
                }
            }
        }
        return h;
    }

    public int manhattan() {
        int m = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int t = mytiles[i][j];
                int row = getRow(t);
                int col = getCol(t);
                int dis = Math.abs(row - i) + Math.abs(col - j);
                m += dis;
            }
        }
        return m;
    }

    private int getRow(int number) {
        if (number == 0) {
            return size - 1;
        }
        return (number - 1) / size; 
    }

    private int getCol(int number) {
        if (number == 0) {
            return size - 1;
        }
        return (number - 1) % size; 
    }

    @Override
    public int estimatedDistanceToGoal() {
        return manhattan();
    }

    public boolean equals(Object y) {
        if (!(y instanceof Board)) {
            return false;
        }
        Board other = (Board) y;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.tileAt(i, j) != other.tileAt(i, j)) {
                    return false;
                }
            }
        }
        return true; 
    }

    /** Returns the string representation of the board. 
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
