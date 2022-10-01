package telran.util;

import java.util.HashMap;
import java.util.stream.Stream;

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
		String wordFormated = formatString(word);
		String anagramFormated = formatString(anagram);
		if (wordFormated.length() != anagramFormated.length()) {
			return false;
		}
		return checkOccurences(wordFormated, anagramFormated);
	}

	private static boolean checkOccurences(String word, String anagram) {
		Stream<Character> charStreamFromWord = word.chars().mapToObj(i -> (char) i);
		Stream<Character> charStreamFromAnagram = anagram.chars().mapToObj(i -> (char) i);
		HashMap<Character, Integer> checkMap = new HashMap<>();
		charStreamFromWord.forEach(ch -> checkMap.merge(ch, 1, (prev, one) -> ++prev));
		charStreamFromAnagram.forEach(ch -> checkMap.computeIfPresent(ch, (k, v) -> (--v == 0) ? null : v));
		return checkMap.isEmpty();
	}

	private static String formatString(String word) {
		return word.replaceAll("\\s+", "").toLowerCase();
	}

}
