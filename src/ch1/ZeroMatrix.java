package ch1;

public class ZeroMatrix {

	public static void main(String[] args) {

		{
			int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
			System.out.println("BEFORE ZEROING OUT");
			System.out.println("------------------");
			print(matrix);
			zeroMatrix(matrix);
			System.out.println("AFTER ZEROING OUT");
			System.out.println("-----------------");
			print(matrix);
		}

		{
			int[][] matrix = { { 0, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
			System.out.println("BEFORE ZEROING OUT");
			System.out.println("------------------");
			print(matrix);
			zeroMatrix(matrix);
			System.out.println("AFTER ZEROING OUT");
			System.out.println("-----------------");
			print(matrix);
		}

	}

	/*
	 * Zero Matrix: 
	 * Write an algorithm such that if an element in an MxN matrix is
	 * 0, its entire row and column are set to 0.
	 * 
	 * 
	 * Solution: 
	 * We can use the first row and column to keep track of the 0s
	 * that are found throughout the matrix.
	 * 
	 * 1. We check to see if the first row/col have a 0. Flagging
	 *    the row/col accordingly.
	 * 2. Check the rest of the rows/columns for 0s. If there is a 0,
	 *    put a 0 in the base col and row.
	 */
	public static void zeroMatrix(int[][] m) {

		// Flags for checking base row/col for 0s.
		boolean rowFlag = false;
		boolean colFlag = false;

		// Loop through the base row.
		for (int j = 0; j < m[0].length; ++j) {
			if (m[0][j] == 0) {
				rowFlag = true;
				break;
			}
		}

		// Loop through the base col.
		for (int i = 0; i < m.length; ++i) {
			if (m[i][0] == 0) {
				colFlag = true;
				break;
			}
		}

		// Loop through the other rows/cols.
		for (int i = 1; i < m.length; ++i) {
			for (int j = 1; j < m[i].length; ++j) {
				if (m[i][j] == 0) {
					m[0][j] = 0; // Set the base col relating to the index of the current element to 0.
					m[i][0] = 0; // Set the base row relating to the index of the current element to 0.
				}
			}
		}

		// Loop through the non-base row
		for (int i = 1; i < m.length; ++i) {
			if (m[i][0] == 0) { // There's a 0 in the first col of the row.
				nullRow(m, i);
			}
		}

		// Loop through the non-base column
		for (int j = 1; j < m[0].length; ++j) {
			if (m[0][j] == 0) { // There's a 0 in the first row of the col.
				nullCol(m, j);
			}
		}

		// Nullify the first row if flag is set.
		if (rowFlag) {
			nullRow(m, 0);
		}

		// Nullify the first col if flag is set.
		if (colFlag) {
			nullCol(m, 0);
		}
	}

	public static void nullRow(int[][] m, int row) {
		for (int j = 0; j < m[0].length; ++j) {
			m[row][j] = 0;
		}
	}

	public static void nullCol(int[][] m, int col) {
		for (int i = 0; i < m.length; ++i) {
			m[i][col] = 0;
		}
	}

	public static void print(int[][] m) {
		for (int i = 0; i < m.length; ++i) {
			for (int j = 0; j < m[i].length; ++j) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
