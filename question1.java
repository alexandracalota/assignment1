import java.util.HashMap;
import java.util.Scanner;

public class Question1 {

	public static Boolean checkPermutation(String first, String second) {

		if (first == null || second == null) {
			System.out.println("One of the string is null");
			return false;
		} else if (first.length() != second.length()) {
			return false;
		} else {
			HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

			for (int i = 0; i < first.length(); i++) {
				Integer val = chars.get(first.charAt(i));
				if (val != null) {
					chars.put(first.charAt(i), val + 1);
				} else {
					chars.put(first.charAt(i), 1);
				}
			}
						
			for (int i = 0; i < second.length(); i++) {
				Integer val = chars.get(second.charAt(i));
				if (val != null) {
					if (val == 1)
						chars.remove(second.charAt(i));
					else
						chars.put(second.charAt(i), val - 1);
				} else {
					return false;
				}
			}

			if (chars.isEmpty())
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String first = scan.next();
		String second = scan.next();

		System.out.println(checkPermutation(first, second));
		
		scan.close();
	}
}
