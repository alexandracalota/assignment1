import java.util.LinkedList;

public class SearchWord {

	public int[][] visited;

	public LinkedList<String> wordSearch(int rows, int columns, char[][] characters, Dictionary dict) {

		LinkedList<String> validWords = new LinkedList<String>();
		visited = new boolean[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				visited[i][j] = false;
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				applyBFS(rows, columns, i, j, characters, dict, validWords, "");
			}
		}

		return validWords;
	}

	public void applyDFS(int rows, int columns, int posX, int posY, char[][] characters, Dictionary dict,
			LinkedList<String> validWords, String word) {

		if (dict.isWord(word)) {
			if (!validWords.contains(word))
				validWords.add(word);
		}

		if (!dict.isPrefix(word) || visited[posX][posY]) {
			return;
		}

		if (dict.isPrefix(word + characters[posX][posY])) {

			int[] offset = { -1, 0, 1 };

			visited[posX][posY] = true;

			for (int i = 0; i < offset.length; i++) {
				for (int j = 0; j < offset.length; j++) {
					int newX = posX + offset[i];
					int newY = posY + offset[j];

					if (0 <= newX && newX < rows && 0 <= newY && newY < columns) {
						applyBFS(rows, columns, newX, newY, characters, dict, validWords, word + characters[posX][posY]);
					}
				}
			}
		}

		visited[posX][posY] = false;
	}
}
