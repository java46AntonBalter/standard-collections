package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import telran.util.*;

class MyArrayTests {

	@Test
	void testMyArray() {
		MyArray<String> arr = new MyArray<>(10);
		assertEquals(10, arr.size);
		
	}

	@Test
	void testSetAll() {
		MyArray<String> arr = new MyArray<>(10);
		assertEquals(null, arr.get(5));
		try {
			arr.set(5, "bla");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("bla", arr.get(5));
		arr.setAll("lab");
		assertEquals("lab", arr.get(0));
		assertEquals("lab", arr.get(9));
		assertEquals("lab", arr.get(5));
		assertEquals(null, arr.get(10));
		try {
			arr.set(5, "bla");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("bla", arr.get(5));
	}

	@Test
	void testGet() {
		MyArray<String> arr = new MyArray<>(10);
		assertEquals(null, arr.get(5));
		assertEquals(null, arr.get(10));
		try {
			arr.set(5, "bla");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("bla", arr.get(5));
		arr.setAll("lab");
		assertEquals("lab", arr.get(0));
		assertEquals("lab", arr.get(9));
		assertEquals("lab", arr.get(5));
		assertEquals(null, arr.get(10));
		try {
			arr.set(5, "bla");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("bla", arr.get(5));
	}

	@Test
	void testSet() {
		MyArray<String> arr = new MyArray<>(10);
		assertThrows(IndexOutOfBoundsException.class, ()-> arr.set(10, "bla"));
		assertEquals(null, arr.get(5));
		try {
			arr.set(5, "bla");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("bla", arr.get(5));
		arr.setAll("lab");
		assertEquals("lab", arr.get(0));
		assertEquals("lab", arr.get(9));
		assertEquals("lab", arr.get(5));
		assertEquals(null, arr.get(10));
		try {
			arr.set(5, "bla");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("bla", arr.get(5));
	}

}
