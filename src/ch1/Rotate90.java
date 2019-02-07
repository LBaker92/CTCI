package ch1;

public class Rotate90 {

	public static void main(String[] args) {
		// Testing with 2x2 matrix.
		{
			int[][] matrix = { { 1, 2 }, { 3, 4 } };
			System.out.println("BEFORE ROTATION");
			System.out.println("---------------");
			print(matrix);
			rotate(matrix);
			System.out.println("\nAFTER ROTATION");
			System.out.println("--------------");
			print(matrix);
		}
		System.out.println();
		
		// Testing with 3x3 matrix.
		{
			int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			System.out.println("BEFORE ROTATION");
			System.out.println("---------------");
			print(matrix);
			System.out.println("\nAFTER ROTATION");
			System.out.println("--------------");
			rotate(matrix);
			print(matrix);
		}
		System.out.println();
		
		// Testing with 4x4 matrix.
		{
			int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
			System.out.println("BEFORE ROTATION");
			System.out.println("---------------");
			print(matrix);
			System.out.println("\nAFTER ROTATION");
			System.out.println("--------------");
			rotate(matrix);
			print(matrix);
		}
		System.out.println();
		
		// Testing with 5x5 matrix.
		{
			int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
					{ 21, 22, 23, 24, 25 } };
			System.out.println("BEFORE ROTATION");
			System.out.println("---------------");
			print(matrix);
			System.out.println("\nAFTER ROTATION");
			System.out.println("--------------");
			rotate(matrix);
			print(matrix);
		}
	}

	public static void print(int[][] m) {
		for (int i = 0; i < m.length; ++i) {
			for (int j = 0; j < m[i].length; ++j) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static boolean rotate(int[][] m) {
		if (m.length == 0 || m[0].length != m.length) { // Must have size and must be NxN.
			return false;
		}
		int N = m.length;
		for (int i = 0; i < N / 2; ++i) { // the amount of times needed to loop over NxN matrix of size N.
			int beginning = i;
			int end = N - 1 - i; // Keep track of where the end col when i increments.
			for (int j = 0; j < N - (2 * i) - 1; ++j) { // Every loop of i, j's set halves itself.
				
				/* Top-left 
				 * Row changes only when i incrememnts, so we use i as our row index.
				 * Col changes with every iteration of j, shifting to the right by j, but also offset by i.
				 * Result: m[i][i + j]
				 */
				
				/* Top-right
				 * Row increases by 1 with every iteration of j.
				 * Col changes only when i increments, shifting to the left by i.
				 * Result: m[i + j][end]
				 */
				
				/* Bottom-right
				 * Row changes only when i increments, shifting to the left by i.
				 * Col changes on every iteration of j, shifting to the left by j.
				 * Result: m[end][[end - j]
				 */
				
				/* Bottom-left
				 * Row changes on every iteration of j, shifting down by 1.
				 * Col changes only when i increments, shifting to the left by i.
				 * Result: m[end - j][i]
				 */
				
				int temp = 0;
				
				// Swap top-right with bottom-left.
				temp = m[beginning + j][end];
				m[beginning + j][end] = m[end - j][i];
				m[end - j][i] = temp;

				// Swap top-left with top-right.
				temp = m[beginning][beginning + j];
				m[beginning][beginning + j] = m[beginning + j][end];
				m[beginning + j][end] = temp;

				// Swap bottom-left with bottom-right.
				temp = m[end - j][i];
				m[end - j][i] = m[end][end - j];
				m[end][end - j] = temp;
			}
		}
		return true;
	}

}
