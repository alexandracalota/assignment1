import java.util.HashSet;

public class Dictionary {
	private HashSet<String> words;
	private HashSet<String> prefixes;

	public Dictionary() {
		this.words = new HashSet<String>();
		this.prefixes = new HashSet<String>();
		prefixes.add("");
	}

	public Dictionary(HashSet<String> words) {
		this();
		setWords(words);
	}

	private void setWords(HashSet<String> words) {

		for (String word : words) {
			this.words.add(word);

			for (int i = 0; i < word.length(); i++) {
				String prefix = word.substring(0, i + 1);
				if (!prefixes.contains(prefix))
					prefixes.add(prefix);
			}
		}

	}

	public boolean isWord(String word) {
		return words.contains(word);
	}

	public boolean isPrefix(String prefix) {
		return prefixes.contains(prefix);
	}

	public HashSet<String> getWords() {
		return words;
	}

	public HashSet<String> getPrefixes() {
		return prefixes;
	}
}
