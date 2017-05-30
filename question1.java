package question1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Custom Scanner which reads lines from a file and parses the information
 * according to what the user is expecting.
 * 
 * @author Alexa
 *
 */
public class MyScanner {
	BufferedReader br;
	StringTokenizer st;

	/**
	 * Constructor which initializes a buffered reader using the known input
	 * file name. The block is surrounded by the methods try and catch in order
	 * to account for possible errors.
	 */
	public MyScanner() {

		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Reads a line, but parses it using StringTokenizer and returns the next
	 * element.
	 * 
	 * @return the next element
	 */
	public String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	/**
	 * Returns the next value read as an integer.
	 * 
	 * @return the next integer
	 */
	public int nextInt() {
		return Integer.parseInt(next());
	}

	/**
	 * Returns the next value read as a long.
	 * 
	 * @return the next long
	 */
	public long nextLong() {
		return Long.parseLong(next());
	}
	
	/**
	 * Returns the next line in the file.
	 * 
	 * @return the next line
	 */
	public String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}


package question1;

import java.util.HashMap;

public class Question1 {

	public static Boolean checkPermutation(String first, String second) {

		if (first == null || second == null) {
			System.out.println("One of the string is null");
			return false;
		} else if (first.length() != second.length()) {
			return false;
		} else {
			HashMap<String, Integer> chars = new HashMap<String, Integer>();

			for (int i = 0; i < first.length(); i++) {
				Integer val = chars.get(String.valueOf(first.charAt(i)));
				if (val != null) {
					chars.put(String.valueOf(first.charAt(i)), val + 1);
				} else {
					chars.put(String.valueOf(first.charAt(i)), 1);
				}
			}
						
			for (int i = 0; i < second.length(); i++) {
				Integer val = chars.get(String.valueOf(second.charAt(i)));
				if (val != null) {
					if (val == 1)
						chars.remove(String.valueOf(second.charAt(i)));
					else
						chars.put(String.valueOf(second.charAt(i)), val - 1);
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
		MyScanner scan = new MyScanner();

		String first = scan.next();
		String second = scan.next();

		System.out.println(checkPermutation(first, second));
	}

}