public class ZeroMatrix 
{
	public static void main(String[] args) {
		int[][] matrix = new int[3][5];

		matrix[0][0] = 1;
		matrix[0][1] = 1;
		matrix[0][2] = 3;
		matrix[0][3] = 7;
		matrix[0][4] = 5;

		matrix[1][0] = 4;
		matrix[1][1] = 2;
		matrix[1][2] = 0;
		matrix[1][3] = 2;
		matrix[1][4] = 1;

		matrix[2][0] = 0;
		matrix[2][1] = 1;
		matrix[2][2] = 2;
		matrix[2][3] = 8;
		matrix[2][4] = 3;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
		
			System.out.println("");
		}

		matrix = zeroMatrix(matrix);

		System.out.println("==== NEW MATRIX ====");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
	
			System.out.println("");
		}
	}

	public static int[][] zeroMatrix(int[][] matrix) {
		int[] rows = new int[matrix.length];
		int[] cols = new int[matrix[0].length];;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}

		for (int i = 0; i < rows.length; i++) {
			int row = rows[i];

			if (row == 1) { 
				int colCount = matrix[row].length;

				for (int j = 0; j < colCount; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < cols.length; i++) {
			int col = cols[i];

			if (col == 1) {
				int rowCount = matrix.length;
	
				for (int j = 0; j < rowCount; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		return matrix;
	}
}

