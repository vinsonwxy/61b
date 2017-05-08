package hw2;      

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;                 

public class PercolationStats {
	private double[] sim;

	public PercolationStats(int N, int T) {
		if (N <= 0 || T <= 0) {
			throw new java.lang.IllegalArgumentException();
		}
		sim = new double[T];

		int x;
		int y;
		Percolation perc;
		for (int i = 0; i < T; i++) {
			perc = new Percolation(N);
			int count = 0;
			while (!perc.percolates()) {
				while (true) {
					x = StdRandom.uniform(N);
					y = StdRandom.uniform(N);
					if (!perc.isOpen(x, y)) {
						break;
					}
				}
				perc.open(x, y);
				count += 1;
			}
			double ratio = ((double) count) / (N * N);
			sim[i] = ratio;
		}
	}

	public double mean() {
		return StdStats.mean(sim);
	}

	public double stddev() {
		return StdStats.stddev(sim);
	}

	public double confidenceLow() {
		return this.mean() - 1.96 * this.stddev() / Math.sqrt(sim.length);
	}

	public double confidenceHigh() {
		return this.mean() + 1.96 * this.stddev() / Math.sqrt(sim.length);
	}

	public static void main(String[] args) {
	    PercolationStats myStats = new PercolationStats(20, 100);
	    System.out.println(myStats.mean());
        System.out.println(myStats.stddev());
        System.out.println(myStats.confidenceLow());
        System.out.println(myStats.confidenceHigh());
    }
}                       
