import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

	private HashMap<Character, LinkedList<Character>> adjacencyMatrix;
	private HashMap<Character, Integer> inDegree;
	private int numberOfEdges;

	public Graph() {
		adjacencyMatrix = new HashMap<Character, LinkedList<Character>>();
		inDegree = new HashMap<Character, Integer>();
		numberOfEdges = 0;
	}

	public void addVertex(char c) {
		if (!adjacencyMatrix.containsKey(c)) {

			adjacencyMatrix.put(c, new LinkedList<Character>());
			inDegree.put(c, 0);
		}
	}

	public void addEdge(char source, char destination) {
		numberOfEdges++;

		if (!adjacencyMatrix.containsKey(source)) {
			addVertex(source);
		}
		if (!adjacencyMatrix.containsKey(destination)) {
			addVertex(destination);
		}

		LinkedList<Character> neighbours = adjacencyMatrix.get(source);
		neighbours.add(destination);
		adjacencyMatrix.put(source, neighbours);

		int oldValue = inDegree.get(destination);
		inDegree.put(destination, oldValue + 1);
	}

	public void removeEdge(char source, Character destination) {
		numberOfEdges--;
		LinkedList<Character> neighbours = adjacencyMatrix.get(source);
		neighbours.remove(destination);
		adjacencyMatrix.put(source, neighbours);

		int oldValue = inDegree.get(destination);
		inDegree.put(destination, oldValue - 1);
	}

	public LinkedList<Character> topologicalSort() {
		LinkedList<Character> sortedNodes = new LinkedList<Character>();
		Queue<Character> stack = new LinkedList<Character>();

		Set<Character> vertexes = adjacencyMatrix.keySet();

		for (Character c : vertexes) {
			if (inDegree.get(c) == 0) {
				stack.add(c);
			}
		}

		while (!stack.isEmpty()) {
			Character c = stack.poll();

			sortedNodes.add(c);

			for (Character n : adjacencyMatrix.get(c)) {
				removeEdge(c, n);
				if (inDegree.get(n) == 0) {
					stack.add(n);
				}
			}
		}

		if (numberOfEdges != 0) {
			return null;
		} else
			return sortedNodes;
	}

	public void printGraph() {
		Set<Character> vertexes = adjacencyMatrix.keySet();
		LinkedList<Character> neighbours;

		for (char v : vertexes) {
			System.out.print(v + ": ");

			neighbours = adjacencyMatrix.get(v);

			for (char u : neighbours) {
				System.out.print(u + " ");
			}

			System.out.println(" inDegree = " + inDegree.get(v));
		}
	}
}
