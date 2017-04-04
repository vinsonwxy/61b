public class OffByN implements CharacterComparator {
	
	private int diff;

	public OffByN(int N) {
		diff = N;
	}

	@Override
	public boolean equalChars(char a, char b) {
		return (a - b == diff || b - a == diff);
	}

}