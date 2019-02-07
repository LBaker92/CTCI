package ch1;

public class Urlify {

	public static void main(String[] args) {
		
		{
			String test = "Mr John Smith    ";
			char[] cTest = test.toCharArray();
			urlify(cTest, 13);
			System.out.println(cTest);
		}
		
		{
			String test = "The Big Test    ";
			char[] cTest = test.toCharArray();
			urlify(cTest, 12);
			System.out.println(cTest);
		}
		
	}
	
	public static void urlify(char[] cStr, int trueLength) {
		int spaceCount = 0;
		for (int i = 0; i < trueLength; ++i) {
			if (cStr[i] == ' ') {
				++spaceCount;
			}
		}
		int newLength = trueLength + (spaceCount * 2); // Only need 2 additional spaces since ' ' is overwritten.
		if (trueLength < newLength) {
			cStr[trueLength] = '\0';
		}
		for (int i = trueLength - 1; i >= 0; --i) { // iterate cStr backwards
			if (cStr[i] == ' ') {
				cStr[newLength - 1] = '0';
				cStr[newLength - 2] = '2';
				cStr[newLength - 3] = '%';
				newLength -= 3;
			} else {
				cStr[newLength - 1] = cStr[i];
				--newLength;
			}
		}
	}

}
