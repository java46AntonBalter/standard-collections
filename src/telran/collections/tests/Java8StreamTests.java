package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Java8StreamTests {

	static class Programmer {
		String name;
		int age;
		String[] technologies;

		public Programmer(String name, int age, String[] technologies) {
			this.name = name;
			this.age = age;
			this.technologies = technologies;
		}

	}

	@Test
	void test() {
		int ar[][] = { { Integer.MAX_VALUE, 2 }, { 3, 4, 5 }, { 7 } };
		assertEquals(Integer.MAX_VALUE + 21L, sumTwoDimArray(ar));
	}

	private Long sumTwoDimArray(int[][] ar) {
		return Arrays.stream(ar).flatMapToInt(a -> Arrays.stream(a)).asLongStream().sum();
	}

}
