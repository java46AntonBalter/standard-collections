package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class ArrayTests {

	@Test
	void halfSum() {
		int arWithHalfSum[] = {40, -20, 50, 10, 20}; //sum = 100, 40 + 10 = 50
		int arWithNoHalfSum[] = {40, -20, 50, 5, 25}; //sum = 100 , no two numbers with sum = 50
		assertTrue(isHalfSumTwoNumbers(arWithHalfSum));
		assertFalse(isHalfSumTwoNumbers(arWithNoHalfSum));
	}
/**
 * 
 * @param array with no limitations of the number values
 * @return true if there are two numbers with sum equaled 
 * half of total sum of a given array
 */
	private boolean isHalfSumTwoNumbers(int[] array) {
		int halfSum = Arrays.stream(array).sum() / 2;
		HashSet<Integer> setHelper = new HashSet<>();
		for(int num: array) {
			if (setHelper.contains(halfSum - num)) {
				return true;
			}
			setHelper.add(num);
		}
		
		return false;
	}
	
	@Test
	void valueWithMaxNegativeTest() {
		int arWithNegative[] = {10, 20000000, 2, 4, 40, -4, 10, -20000000, -2};
		int arWithNoNegative[] = {10, 20, 2, 4, 40, -14, 10, -21, -3};
		assertEquals(20000000, valueWithMaxNegative(arWithNegative));
		assertEquals(-1, valueWithMaxNegative(arWithNoNegative));
	}
	/**
	 * 
	 * @param array with numbers that may have the huge values
	 * @return maximal value with existing negative image (negative value with same absolute value)
	 * if no value with its negative image the function returns -1
	 */
	private Integer valueWithMaxNegative(int[] array) {
		int res = -1;
		HashSet<Integer> setHelper = new HashSet<>();
		for (int num: array) {
			int absNum = Math.abs(num);
			if (setHelper.contains(-num) && absNum > res) {
				res = absNum;
			}
			setHelper.add(num);
		}
		
		return res;
	}
	/**
	 * The method doesn't update a given array
	 * @param <T>
	 * @param array
	 * @return true if there is exactly one swap for getting sorted array
	 * examples: {1, 2, 3, 10, -1, 5, 6} -> false
	 * {1, 2, 3, 5, 6, 10} -> false
	 * {1,3,2,4, 3, 10} -> false
	 * {10, 2, 3, 4, 1} -> true
	 * {1, 2, 4, 3, 5, 10} -> true
	 * {1, 5, 3, 4, 2, 10} -> true
	 * {"lmn", "ab", "bc", "cd", "a"} -> true
	 * An Array should contain Comparable elements
	 */
	@Test
	void isOneSwapTestFalse() {
		Integer ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		Integer ar2[] = { 1, 2, 3, 4, 5, 10 };
		Integer ar3[] = { 5, 1, 2, 4, 6, 10 };
		Integer ar4[] = { 1, 5, 2, 4, 3, 10 };
		Integer ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		Integer ar6[] = {1, 3, 20, 4, 5, 6, 10};
		Integer ar7[] = {1, 3, 20, 4, 5, 11, 2};
		

		assertFalse(isOneSwapForSorted(ar1));
		assertFalse(isOneSwapForSorted(ar2));
		assertFalse(isOneSwapForSorted(ar3));
		assertFalse(isOneSwapForSorted(ar4));
		assertFalse(isOneSwapForSorted(ar5));
		assertFalse(isOneSwapForSorted(ar6));
		assertFalse(isOneSwapForSorted(ar7));
		
	}
	@Test
	void isOneSwapTestTrue() {
		
		Integer ar1[] = { 10, 2, 3, 4, 1 };
		Integer ar2[] = { 1, 2, 4, 3, 5, 10 };
		Integer ar3[] = { 1, 2, 3, 10, 5, 4 };
		Integer ar4[] = { 1, 5, 3, 4, 2, 10 };
		Integer ar5[] = { 1, 2, 3, 4, 10, 5 };
		Integer ar6[] = { 2, 1, -3, 4, 5, 10 };
		Integer ar7[] = { 3, 2, 1, 4, 5, 6 };
		String ar8[] = { "lmn", "ab", "bc", "cd", "a" };
		String ar9[] = {"lmn", "ab", "ab", "ab", "ab", "a"};

		
		assertTrue(isOneSwapForSorted(ar1));
		assertTrue(isOneSwapForSorted(ar2));
		assertTrue(isOneSwapForSorted(ar3));
		assertTrue(isOneSwapForSorted(ar4));
		assertTrue(isOneSwapForSorted(ar5));
		assertTrue(isOneSwapForSorted(ar6));
		assertTrue(isOneSwapForSorted(ar7));
		assertTrue(isOneSwapForSorted(ar8));
		assertTrue(isOneSwapForSorted(ar9));
		
	}


	<T> boolean isOneSwapForSorted(T[] array) {
		//The method returns true if an given array is not sorted
		//but to do it sorted there should be done only one swap of any numbers (not mandatory 
		//that the being swapped numbers placed one after other)
		//example1: {1, 10, 2, 3, 6, 4} - the method returns "false"
		//example2: {1, 6, 3, 4, 2, 10} - the method return "true", only one swap 2 with 6
		int index1 = -1;
		int index2 = -1;
		int length = array.length - 1;
		for (int i = 0; i < length; i++) {
			if (!sortCheck(array, i, i + 1)) {
				if (index1 == -1) {
					index1 = i;
				} else if(index2 != -1) {
					return false;
				} else {
					index2 = i + 1;
				}
			}
		}
		return index1 == -1  ? false : checkIndexes(array, index1, index2);
		
}

	private static <T> boolean checkIndexes(T[] array, int index1, int index2) {
	
		return index2 == -1 ? checkOneIndex(array, index1) : checkTwoIndexes(array, index1, index2);
	}

	private static <T> boolean checkTwoIndexes(T[] array, int index1, int index2) {
		
		return (index2 == array.length - 1 || sortCheck(array, index1, index2 + 1) ) && 
				sortCheck(array, index2, index1 + 1) && (index1 == 0 ||
				sortCheck(array, index1 - 1, index2 ));
	}

	private static <T> boolean checkOneIndex(T[] array, int index) {
		
		return (index == array.length - 2 || sortCheck(array, index, index + 2)) && 
				(index == 0 || sortCheck(array, index - 1, index + 1))
				;
	}

	
	@SuppressWarnings("unchecked")
	static private <T>  boolean sortCheck(T[] array, int index1, int index2) {

		return ((Comparable<T>) array[index1]).compareTo(array[index2]) <= 0 ? true : false;
	}

}