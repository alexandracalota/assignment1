import java.util.LinkedList;

public class Dictionary {
	private LinkedList<String> words;
	private LinkedList<String> prefixes;

	public Dictionary(LinkedList<String> words) {
		this.words = words;
		this.prefixes = new LinkedList<String>();
		prefixes.add("");
		for (String word : words) {
			addWord(word);
		}
	}

	private void addWord(String word) {

		for (int i = 0; i < word.length(); i++) {
			String prefix = word.substring(0, i + 1);
			if (!prefixes.contains(prefix))
				prefixes.add(prefix);
		}

	}

	public boolean isWord(String word) {
		return words.contains(word);
	}

	public boolean isPrefix(String prefix) {
		return prefixes.contains(prefix);
	}

	public LinkedList<String> getWords() {
		return words;
	}

	public void setWords(LinkedList<String> words) {
		this.words = words;
	}

	public LinkedList<String> getPrefixes() {
		return prefixes;
	}

	public void setPrefixes(LinkedList<String> prefixes) {
		this.prefixes = prefixes;
	}
}
