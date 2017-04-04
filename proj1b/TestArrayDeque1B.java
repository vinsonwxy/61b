import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

	@Test
	public void testArrayDeque1B() {
		StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
		ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
		while (true) {
			double numberBetweenZeroAndOne = StdRandom.uniform();
			if (numberBetweenZeroAndOne < 0.25) {
				sad1.addFirst(1);
				ads1.addFirst(1);
				assertEquals("addFirst(1)", ads1.get(0), sad1.get(0));
			} else if (numberBetweenZeroAndOne < 0.5) {
				sad1.addLast(2);
				ads1.addLast(2);
				assertEquals("addLast(2)", ads1.get(0), sad1.get(0));
			} else if (numberBetweenZeroAndOne < 0.75) {
				if (sad1.size() == 0) {
					continue;
				}
				Integer x1 = sad1.removeFirst();
				Integer x2 = ads1.removeFirst();
				assertEquals("removeFirst()", x1, x2);
			} else {
				if (sad1.size() == 0) {
					continue;
				}
				Integer x1 = sad1.removeLast();
				Integer x2 = ads1.removeLast();
				assertEquals("removeLast()", x1, x2);
			}

		}
	}

	public static void main(String[] args) {

	} 

}