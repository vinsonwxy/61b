package hw3.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayList;

public class Solver {
	private MinPQ<SearchNode> pq;

	public Solver(WorldState initial) {
		pq = new MinPQ<SearchNode>();
		SearchNode initialNode = new SearchNode(initial, 0, null);
		pq.insert(initialNode);
		while (!pq.min().getWorldState().isGoal()) {
			SearchNode minNode = pq.delMin();
			for (WorldState w: minNode.getWorldState().neighbors()) {
				if (minNode.getPrev() == null || !w.equals(minNode.getPrev().getWorldState())) {
					SearchNode nbNode = new SearchNode(w, minNode.getNumMoves() + 1, minNode);
					pq.insert(nbNode);
				}
			}
		}
	}

	public int moves() {
		return pq.min().getNumMoves();
	}

	public Iterable<WorldState> solution() {
		ArrayList<WorldState> wsList = new ArrayList<WorldState>();
		SearchNode p = pq.min();
		while (p != null) {
			wsList.add(0, p.getWorldState());
			p = p.getPrev();
		}
		return wsList;
	}

	private class SearchNode implements Comparable<SearchNode> {
		private WorldState ws;
		private int numMoves;
		private SearchNode prev;
		private int edtg;

		public SearchNode(WorldState ws, int numMoves, SearchNode prev) {
			this.ws = ws;
			this.numMoves = numMoves;
			this.prev = prev;
			edtg = ws.estimatedDistanceToGoal();
		}

		public WorldState getWorldState() {
			return ws;
		}

		public int getNumMoves() {
			return numMoves;
		}

		public SearchNode getPrev() {
			return prev;
		}

		public int getEdtg() {
			return edtg;
		}

		@Override
		public int compareTo(SearchNode other) {
			return this.numMoves + this.edtg - (other.numMoves + other.edtg);
		}
	}
}