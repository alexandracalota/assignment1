import java.util.LinkedList;

public class BuildAlphabet {

	private static Graph buildGraph(LinkedList<String> words) {
		Graph alphabet = new Graph();

		if (words.size() == 1) {
			for (int i = 0; i < words.get(0).length(); i++) {
				alphabet.addVertex(words.get(0).charAt(i));
			}

			return alphabet;
		}

		for (int i = 0; i < words.size() - 1; i++) {

			char source = 0, destination = 0;
			int j = 0;

			String word1 = words.get(i);
			String word2 = words.get(i + 1);

			while ((j < word1.length()) && (j < word2.length())) {
				if (word1.charAt(j) != word2.charAt(j)) {
					source = word1.charAt(j);
					destination = word2.charAt(j);
					break;
				} else {
					alphabet.addVertex(word1.charAt(j));
					alphabet.addVertex(word2.charAt(j));
					j++;
				}
			}

			if (j < word1.length() && j == word2.length()) {
				return null;
			}

			if ((j != word1.length()) && (j != word2.length())) {
				alphabet.addEdge(source, destination);
				int k = j;
				while ((j < word1.length())) {
					alphabet.addVertex(word1.charAt(j));
					j++;
				}

				while ((k < word1.length())) {
					alphabet.addVertex(word2.charAt(k));
					k++;
				}
			}
		}

		return alphabet;
	}

	public static LinkedList<Character> buildAlphabet(LinkedList<String> words) {

		LinkedList<Character> alphabet = new LinkedList<Character>();

		Graph graph = buildGraph(words);

		graph.printGraph();

		alphabet = graph.topologicalSort();

		return alphabet;

	}

}
