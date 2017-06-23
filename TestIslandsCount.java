
public class TestIslandsCount {

	@org.junit.Test
	public void test1() {

		System.out.println("----Test 1----");

		boolean[][] matrix = { { false, true, false, true }, { true, true, false, false },
				{ false, false, true, false }, { false, false, true, false } };

		int numberOfIslands = CountIslands.countIslands(matrix);

		System.out.println("Number of islands: " + numberOfIslands);
	}

	@org.junit.Test
	public void test2() {

		System.out.println("----Test 2----");

		boolean[][] matrix = { { true, true, false, false, false }, { false, true, false, false, true },
				{ true, false, false, true, true }, { false, false, false, false, false },
				{ true, false, true, false, true } };

		int numberOfIslands = CountIslands.countIslands(matrix);

		System.out.println("Number of islands: " + numberOfIslands);
	}
}
