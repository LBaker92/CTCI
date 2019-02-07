package ch1;

public class IsUnique {

	public static void main(String[] args) {
		{
			String test = "Hello";
			System.out.println(isUnique(test));
		}
		
		{
			String test = "true";
			System.out.println(isUnique(test));
		}
	}

	public static boolean isUnique(String s) {
		if (s.length() > 128) { // String has more characters than ASCII table.
			return false;
		}
		char[] cStr = s.toCharArray();
		boolean[] charUsed = new boolean[128]; // Keep track of the characters used from ASCII table.
		for (int i = 0; i < cStr.length; ++i) {
			int charToNum = (int) cStr[i];
			if (charUsed[charToNum]) {
				return false;
			}
			charUsed[charToNum] = true;
		}
		return true;
	}

}
