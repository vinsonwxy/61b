public class Palindrome {

	public static Deque<Character> wordToDeque(String word) {
		Deque<Character> characterDeque = new ArrayDequeSolution<>();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			characterDeque.addLast(c);
		}
		return characterDeque;
	}

	public static boolean isPalindrome(String word) {
		if (word.length() <= 1) {
			return true;
		}
		int i = 0;
		int j = word.length() - 1;
		while (i < j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			i += 1;
			j -= 1;
		}
		return true;
	}

	public static boolean isPalindrome(String word, CharacterComparator cc) {
		if (word.length() <= 1) {
			return true;
		}
		int i = 0;
		int j = word.length() - 1;
		while (i < j) {
			if (!cc.equalChars(word.charAt(i), word.charAt(j))) {
				return false;
			}
			i += 1;
			j -= 1;
		}
		return true;
	}
}