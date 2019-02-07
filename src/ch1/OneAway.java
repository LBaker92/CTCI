package ch1;

public class OneAway {

	public static void main(String[] args) {

		{
			String a = "pes";
			String b = "test";
			System.out.println(oneAway(a, b));
		}
	}

	public static boolean oneAway(String a, String b) {
		if (Math.abs(a.length() - b.length()) > 1) { // Check if the string sizes are off by more than 1.
			return false;
		}

		int i = 0;
		int j = 0;
		boolean difference = false;
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) != b.charAt(j)) {
				if (difference) {
					return false;
				}
				difference = true;
				if (a.length() != b.length()) {
					return false;
				}
			}
			i++;
			j++;
		}
		return true;
	}
}
