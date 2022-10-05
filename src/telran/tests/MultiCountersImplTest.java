package telran.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.structure.*;

class MultiCountersImplTest {
	String arr[] = {"a", "a", "a", "b", "b", "b", "c", "c", "d", "d", "e", "f"};
	MultiCountersImpl map = new MultiCountersImpl();

	@BeforeEach
	void setUp() throws Exception {
		for (String i : arr) {
			map.addItem(i);
		}
	}

	@Test
	void addItemTest() {
		assertEquals(1, map.addItem("g"));
		assertEquals(2, map.addItem("e"));
	}
	
	@Test
	void getValueTest() {
		assertEquals(3, map.getValue("a"));
		assertEquals(2, map.getValue("c"));
		assertEquals(1, map.getValue("f"));
	}
	@Test
	void removeTest() {
		assertTrue(map.remove("a"));
		assertFalse(map.remove("x"));
	}
	@Test
	void getMaxItemsSet () {
		System.out.println(map.getMaxItems());
		String arr2[] = {"x", "x", "x", "x", "x"};
		for (String i : arr2) {
			map.addItem(i);
		}
		System.out.println(map.getMaxItems());		
	}

}
