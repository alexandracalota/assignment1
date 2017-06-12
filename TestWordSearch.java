import java.util.LinkedList;

public class TestWordSearch {

	@org.junit.Test
	public void test1() {
		LinkedList<String> words = new LinkedList<String>();
		words.add("CAR");
		words.add("CARD"); 
		words.add("CART");
		words.add("CAT");
		Dictionary dict = new Dictionary(words);

		for (String word : dict.getWords()) {
			System.out.print(word + " ");
		}

		System.out.println();

		for (String prefix : dict.getPrefixes()) {
			System.out.print(prefix + " ");
		}
		System.out.println();

		char[][] characters = { { 'A', 'A', 'R' }, { 'T', 'C', 'D' } };

		LinkedList<String> check = new LinkedList<String>();
		check.add("CAR");
		check.add("CARD");
		check.add("CAT");

		SearchWord alg = new SearchWord();

		LinkedList<String> fromAlg = alg.wordSearch(2, 3, characters, dict);

		for (String str : fromAlg) {
			System.out.print(str + " ");
		}
		System.out.println();
	}

	@org.junit.Test
	public void test2() {
		LinkedList<String> words = new LinkedList<String>();
		words.add("ANA");
		words.add("CAB"); 
		words.add("RDY");
		words.add("POQ");
		words.add("CANT");
		words.add("TALL");
		Dictionary dict = new Dictionary(words);

		System.out.println("\n---Test 2\n");
		
		for (String word : dict.getWords()) {
			System.out.print(word + " ");
		}

		System.out.println();

		for (String prefix : dict.getPrefixes()) {
			System.out.print(prefix + " ");
		}
		System.out.println();

		char[][] characters = { { 'A', 'B', 'C', 'R', 'C' }, 
								{ 'A', 'N', 'A', 'D', 'X' }, 
								{ 'L', 'D', 'B', 'Y', 'Z' },
								{ 'M', 'T', 'A', 'L', 'C' }, 
								{ 'N', 'P', 'O', 'Q', 'R' }, };

		LinkedList<String> check = new LinkedList<String>();
		check.add("ANA");
		check.add("CAB");
		check.add("RDY");
		check.add("POQ");

		SearchWord alg = new SearchWord();

		LinkedList<String> fromAlg = alg.wordSearch(5, 5, characters, dict);

		System.out.println("final list:");
		
		for (String str : fromAlg) {
			System.out.print(str + " ");
		}
		System.out.println();
	}
}
