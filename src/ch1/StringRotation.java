package ch1;

public class StringRotation {

	public static void main(String[] args) {
		
		{
			String a = "waterbottle";
			String b = "erbottlewat";
			System.out.println(isRotation(a, b));
		}
		
		{
			String a = "racecar";
			String b = "cecarra";
			System.out.println(isRotation(a, b));
		}
		
		{
			String a = "teststring";
			String b = "notsamestr";
			System.out.println(isRotation(a, b));
		}
	}

	/*
	 * Assume you have a method isSubstring which checks if one word is a substring
	 * of another.
	 * 
	 * Given two strings, sl and s2, write code to check if s2 is a rotation of sl
	 * using only one call to isSubstring (e.g., "waterbottle" is a rotation
	 * of"erbottlewat").
	 * 
	 * SOLUTION: 
	 * In order to rotate a string, you must split the string up and shift
	 * the pieces around. So, we can assume that a is composed of substrings xy. If
	 * b is a rotation of a, then we can say that b is yx, since it was originally 
	 * xy, but was shifted. If you were to concatenate a with itself, you would get
	 * a string composed of substrings xyxy. If you compare xyxy with yx, you can
	 * see that yx does exist within xyxy. (x-yx-y).
	 * 
	 * EX:
	 * a = waterbottle
	 * b = erbottlewat
	 * aa = waterbottlewaterbottle
	 *         ^---------^
	 * wat(erbottlewat)erbottle
	 */
	public static boolean isRotation(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		if (a.length() < 1) {
			return false;
		}

		String temp = a + a;
		return isSubstring(temp, b);
	}

	
	/*
	 * Compare each letter in string a with the letters in string b, keeping track of how many chars matched.
	 * If we loop through the entire b string and the number of matches is the same as the
	 * amount of characters in b, then b is a substring of a.
	 */
	public static boolean isSubstring(String a, String b) {
		if (a.length() < 1 || b.length() < 1) {
			return false;
		}
		if (b.length() >= a.length()) {
			return false;
		}
		for (int i = 0; i <= a.length() - b.length(); ++i) { // Loop through main string's characters.
			int matchNum = 0;
			for (int j = 0; j < b.length(); ++j) { // Loop through pattern string's characters.
				if (a.charAt(i + j) != b.charAt(j)) {
					break;
				}
				++matchNum;
			}
			if (matchNum == b.length()) {
				return true;
			}
		}
		return false;
	}

}
