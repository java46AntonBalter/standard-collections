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
	<T extends Comparable<T>> boolean isOneSwapForSorted(T[] array){
		T[] arr = array.clone();
		int count = 0, first = 0, second = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i].compareTo(arr[i-1]) < 0) {
				count++;
				if(first == 0) {
					first = i;
				} else {
					second = i;
				}
			}
		}
		if (count == 0 || count > 2) {
	        return false;
		}  
		
		if (count == 2) {
	        swap(arr, first - 1, second);
		} else {
	        swap(arr, first - 1, first);
		}
		
		for (int i = 1; i < arr.length; i++) {
	        if (arr[i].compareTo(arr[i-1]) < 0) {
	            return false;
	        }
		}    
		return true;
	}
	
	private static <T> void swap(T[] arr, int i, int j)
	{
	    T temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	@Test
	void isOneSwapTest() {
		Integer[] arr = {1, 2, 3, 10, -1, 5, 6};
		assertFalse(isOneSwapForSorted(arr));
		Integer[] arr2 = {1, 2, 3, 5, 6, 10};
		assertFalse(isOneSwapForSorted(arr2));
		Integer[] arr3 = {1,3,2,4, 3, 10};
		assertFalse(isOneSwapForSorted(arr3));
		Integer[] arr4 = {10, 2, 3, 4, 1};
		assertTrue(isOneSwapForSorted(arr4));
		Integer[] arr5 = {1, 2, 4, 3, 5, 10};
		assertTrue(isOneSwapForSorted(arr5));
		Integer[] arr6 =  {1, 5, 3, 4, 2, 10};
		assertTrue(isOneSwapForSorted(arr6));
		String[] arr7 = {"lmn", "ab", "bc", "cd", "a"};
		assertTrue(isOneSwapForSorted(arr7));
		Integer arTrue1[] = {1, 6, 3, 4, 2, 10};
		assertTrue(isOneSwapForSorted(arTrue1));
		Integer arTrue2[] = {1, 2, 4, 3, 6, 10};
		assertTrue(isOneSwapForSorted(arTrue2));
		Integer arTrue3[] = {10, 2, 3, 4, 6, 1};
		assertTrue(isOneSwapForSorted(arTrue3));
		Integer arTrue4[] = {3, 2, 3, 4, 6, 10};
		assertTrue(isOneSwapForSorted(arTrue4));
		Integer arTrue5[] = {1, 2, 3, 4, 6, 10, 7};
		assertTrue(isOneSwapForSorted(arTrue5));
		Integer arFalse1[] = {1, 10, 2, 3, 6, 4};
		assertFalse(isOneSwapForSorted(arFalse1));
		Integer arFalse2[] = {1, 2, 4, 2, 10, 6};
		assertFalse(isOneSwapForSorted(arFalse2));
		Integer arFalse3[] = {1, 2, 3, 4, 6, 10};
		assertFalse(isOneSwapForSorted(arFalse3));
	}

}
