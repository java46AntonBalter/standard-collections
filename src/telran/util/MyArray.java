package telran.util;

import java.util.*;

/**
 * All methods of the class should have complexity O[1]
 * 
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {

	private Map<Integer, T> arr = new HashMap<Integer, T>();
	private T defaultValue = null;
	public int size;

	public MyArray(int size) {
		this.size = size;
	}

	/**
	 * sets all array's elements with a given value
	 * 
	 * @param value
	 */
	public void setAll(T value) {
		arr = new HashMap<Integer, T>();
		defaultValue = value;
	}

	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		return (index >= 0 && index < size) ? arr.getOrDefault(index, defaultValue) : null;
	}

	/**
	 * sets a given value at a given index throws IndexOutOfBoundsException in the
	 * case of wrong index
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) throws Exception {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		arr.put(index, value);

	}
}
