/** This class outputs all off-by-1 palindromes in the words file in the current directory. */
public class OffByOnePalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words.txt");

        while (!in.isEmpty()) {
            String word = in.readString();
            OffByOne cc = new OffByOne();
            if (word.length() >= minLength && Palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }
    }
} 