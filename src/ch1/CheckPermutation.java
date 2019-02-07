package ch1;

import java.util.Arrays;

public class CheckPermutation {

	public static void main(String[] args) {

		{
			String a = "True";
			String b = "rueT";
			System.out.println(isPermutation(a, b));
		}
		
		{
			String a = "False";
			String b = "Eslaf";
			System.out.println(isPermutation(a, b));
		}

	}

	public static boolean isPermutation(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		char[] aStr = a.toCharArray();
		char[] bStr = b.toCharArray();
		Arrays.sort(aStr);
		Arrays.sort(bStr);
		for (int i = 0; i < aStr.length; ++i) {
			if (aStr[i] != bStr[i]) {
				return false;
			}
		}
		return true;
	}

}
