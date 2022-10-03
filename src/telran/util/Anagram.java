package telran.util;

import java.util.HashMap;

public class Anagram {
/**
 * 
 * @param word
 * @param anagram
 * @return true if anagram is one of the possible anagrams of a given word
 * anagram is a string containing all symbols from a given word with different order
 * Example: yellow (wolely, lowlye, yellow) , wrong anagrams (yello, yelllw)
 */
	public static boolean isAnagram(String word, String anagram) {
		
		if(word.length() != anagram.length()) {
			return false;
		}
		HashMap<Character, Integer> charCountsMap = getCharCounts(word);
		for(char c: anagram.toCharArray()) {

			if (charCountsMap.compute(c, (k, v) -> v == null ? -1 : v - 1 ) < 0 )
				return false;
		}
		return true;
	}

	private static HashMap<Character, Integer> getCharCounts(String word) {
		HashMap<Character, Integer> res = new HashMap<>();
		for(char c: word.toCharArray()) {
			res.merge(c, 1, (a, b) -> a + b);
		}
		return res;
	}


}