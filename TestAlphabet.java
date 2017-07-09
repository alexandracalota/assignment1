import java.util.LinkedList;

public class TestAlphabet {
	@org.junit.Test
	public void test1() {

		System.out.println("----Test1");

		LinkedList<String> words = new LinkedList<String>();

		words.add("ART");
		words.add("RAT");
		words.add("CAT");
		words.add("CAR");

		System.out.println(words.toString());

		LinkedList<Character> alphabet = BuildAlphabet.buildAlphabet(words);

		if (alphabet == null)
			System.out.println("null");
		else
			System.out.println("\n" + alphabet.toString());
	}

	@org.junit.Test
	public void test2() {
		System.out.println("\n----Test2");

		LinkedList<String> words = new LinkedList<String>();

		words.add("cuvant");

		System.out.println(words.toString());

		LinkedList<Character> alphabet = BuildAlphabet.buildAlphabet(words);

		if (alphabet == null)
			System.out.println("null");
		else
			System.out.println("\n" + alphabet.toString());
	}

	@org.junit.Test
	public void test3() {
		System.out.println("\n----Test3");

		LinkedList<String> words = new LinkedList<String>();

		System.out.println(words.toString());

		LinkedList<Character> alphabet = BuildAlphabet.buildAlphabet(words);

		if (alphabet == null)
			System.out.println("null");
		else
			System.out.println("\n" + alphabet.toString());
	}

	@org.junit.Test
	public void test4() {

		System.out.println("\n----Test4");

		LinkedList<String> words = new LinkedList<String>();

		words.add("ART");
		words.add("RAT");
		words.add("AAT");
		words.add("CAR");

		System.out.println(words.toString());

		LinkedList<Character> alphabet = BuildAlphabet.buildAlphabet(words);

		if (alphabet == null)
			System.out.println("null");
		else
			System.out.println("\n" + alphabet.toString());
	}
}
