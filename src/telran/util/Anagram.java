package telran.util;

import java.util.HashMap;
import java.util.Map;

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
		char[] wordArr = getCharArr(word);
		char[] anagramArr = getCharArr(anagram);
		if (wordArr.length != anagramArr.length) {
			return false;
		}
		Map<Character, Integer> charOccurencesMap = getMapOccurences(wordArr);
		return checkOccurences(charOccurencesMap, anagramArr);
	}

	private static char[] getCharArr(String word) {
		return word.replaceAll("\\s+", "").toLowerCase().toCharArray();
	}

	private static boolean checkOccurences(Map<Character, Integer> occMap, char[] anagramArr) {
		for (Character ch : anagramArr) {
			if (occMap.containsKey(ch)) {
				occMap.computeIfPresent(ch, (k, v) -> --v);
				if (occMap.get(ch) == 0) {
					occMap.remove(ch);
				}
			}
		}
		return occMap.isEmpty();
	}

	private static Map<Character, Integer> getMapOccurences(char[] wordArr) {
		Map<Character, Integer> res = new HashMap<>();
		for (Character ch : wordArr) {
			Integer count = res.getOrDefault(ch, 0);
			res.put(ch, count + 1);
		}
		return res;
	}
}
