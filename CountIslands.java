
public class CountIslands {

	public static void DFS(boolean matrix[][], int i, int j, boolean visited[][]) {

		int rows = matrix.length;
		int columns = matrix[0].length;

		int row[] = { -1, 1, 0, 0 };
		int col[] = { 0, 0, -1, 1 };

		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int newI = i + row[k];
			int newJ = j + col[k];
			if ((newI < rows) && (newI >= 0) && (newJ < columns) && (newJ >= 0))
				if (!visited[newI][newJ] && matrix[newI][newJ]) {
					DFS(matrix, newI, newJ, visited);
				}
		}

	}

	public static int countIslands(boolean matrix[][]) {
		int count = 0;
		int rows = matrix.length;
		int columns = matrix[0].length;

		boolean visited[][] = new boolean[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				visited[i][j] = false;
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] && !visited[i][j]) {
					DFS(matrix, i, j, visited);
					++count;
				}
			}
		}

		return count;
	}
}
