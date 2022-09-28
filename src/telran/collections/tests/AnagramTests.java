package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.*;

class AnagramTests {

	@Test
	void testIsAnagram() {
		assertFalse(Anagram.isAnagram("Astronomer", "Moon starrer"));
		assertTrue(Anagram.isAnagram("Rebuild", "builder"));
		assertTrue(Anagram.isAnagram("Treason", "senator"));
		assertTrue(Anagram.isAnagram("School master", "The classroom"));
		assertFalse(Anagram.isAnagram("Treason", "senutor"));
		assertTrue(Anagram.isAnagram("1122", "2211"));
	}

}
