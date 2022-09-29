package telran.util;

import java.util.HashMap;

public class Anagram {
	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return true if anagram is one of the possible anagrams of a given word
	 *         anagram is a string containing all symbols from a given word with
	 *         different order Example: yellow (wolely, lowlye, yellow) , wrong
	 *         anagrams (yello, yelllw)
	 */
	public static boolean isAnagram(String word, String anagram) {
		boolean res = false;
		if (word.length() == anagram.length()) {
			HashMap<Character, Integer> mapLetters = getMapLetters(word);
			res = true;
			for (char letter : anagram.toCharArray()) {
				Integer count = mapLetters.getOrDefault(letter, 0);
				if (count == 0) {
					res = false;
					break;
				}
				mapLetters.put(letter, count - 1);
			}
		}
		return res;
	}

	private static HashMap<Character, Integer> getMapLetters(String word) {
		HashMap<Character, Integer> res = new HashMap<>();
		for (char letter : word.toCharArray()) {
			Integer count = res.getOrDefault(letter, 0);
			res.put(letter, count + 1);
		}
		return res;
	}
}