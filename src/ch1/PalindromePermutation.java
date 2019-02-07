package ch1;

import java.util.HashMap;
import java.util.Map.Entry;

public class PalindromePermutation {

	public static void main(String[] args) {

		{
			String test = "Tact Coa";
			System.out.println(isPalindromePerm(test));
		}

		{
			String test = "tasfgavb";
			System.out.println(isPalindromePerm(test));
		}

		{
			String test = "tatee";
			System.out.println(isPalindromePerm(test));
		}

		{
			String test = "123xxxTentacion";
			System.out.println(isPalindromePerm(test));
		}

	}

	/*
	 * Given a string, write a function to check if it is a permutation of a palin­
	 * drome. A palindrome is a word or phrase that is the same forwards and
	 * backwards. A permutation is a rearrangement of letters. The palindrome does
	 * not need to be limited to just dictionary words.
	 * 
	 * EXAMPLE Input: Tact Coa Output: True (permutations: "taco cat", "atco eta",
	 * etc.)
	 */
	public static boolean isPalindromePerm(String s) {
		int oddCharLimit = 1;
		char[] cStr = s.toLowerCase().toCharArray();
		HashMap<Character, Integer> cMap = new HashMap<>();
		for (int i = 0; i < cStr.length; ++i) { // Loop through the characters
			if (Character.isLetter(cStr[i])) {
				if (cMap.containsKey(cStr[i])) {
					cMap.put(cStr[i], cMap.get(cStr[i]) + 1); // Increase the occurence of that character.
				} else {
					cMap.put(cStr[i], 1);
				}
			}
		}
		int numOddChars = 0;
		for (Entry<Character, Integer> e : cMap.entrySet()) { // Loop through map entries
			if (e.getValue() % 2 == 1) { // odd number
				if (numOddChars > oddCharLimit) {
					return false;
				} else {
					numOddChars++;
				}
			}
		}
		return true;
	}

}