import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

	static boolean notIncludedFour(int n) {
		int tmp = 0;
		while (n > 0) {
			// System.out.println("n: "+n);
			tmp = n % 10;
			if (tmp == 4)
				return false;
			n = n / 10;
		}
		return true;
	}

	static void testNotIncludedFour() {
		for (int i = 1; i < 1000000; i++) {
			if (!notIncludedFour(i))
				System.out.println(i);
		}
	}

	static void creatTestData(int testset) {
		System.out.println(100);
		int max = 100000;
		int data = 0;
		if (testset == 2)
			max = 1000000000;
		for (int i = 0; i < 100; ++i) {
			do {
				data = (int) (Math.random() * max);
			} while (notIncludedFour(data));
			System.out.println(data);
		}
	}

	/**
	 * cost 13.8 sec in set2
	 * 
	 * @param T
	 * @param reader
	 * @param writer
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	static void doItByCheck(int T, BufferedReader reader, PrintWriter writer)
			throws NumberFormatException, IOException {
		int N = 0, A = 0, B = 0;

		for (int i = 1; i <= T; ++i) {
			// cal A, B
			N = Integer.parseInt(reader.readLine());

			// split number
			// 4's multiple doesn't mean it has digit '4'
			for (int j = 1; j < N; ++j) {
				A = N - j;
				B = j;

				if (notIncludedFour(A) && notIncludedFour(B)) {
					break;
				}
			}

			// ans
			writer.printf("Case #%d: %d %d\n", i, A, B);
		}

	}

	/**
	 * cost 0.674 sec in set2
	 * 
	 * @param T
	 * @param reader
	 * @param writer
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	static void doItByString(int T, BufferedReader reader, PrintWriter writer)
			throws NumberFormatException, IOException {
		int A = 0, B = 0;

		for (int i = 1; i <= T; ++i) {
			// Case
			// cal A, B
			String strN = reader.readLine();
			int len = strN.length();
			StringBuilder sb1 = new StringBuilder(len);
			StringBuilder sb2 = new StringBuilder(len);

			for (int j = 0; j < len; ++j) {
				char c = strN.charAt(j);
				if (c == '4') {
					sb1.append('2');
					sb2.append('2');
				} else {
					sb1.append(c);
					sb2.append('0');
				}
			}
			A = Integer.parseInt(sb1.toString());
			B = Integer.parseInt(sb2.toString());

			// ans
			writer.printf("Case #%d: %d %d\n", i, A, B);
		}

	}

	public static void main(String[] args) throws IOException {

		// testNotIncludedFour();

		// creatTestData(2);

		long startTime = System.currentTimeMillis();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int T = 0;
		T = Integer.parseInt(reader.readLine());

		doItByString(T, reader, writer);

		long cur = System.currentTimeMillis();
		long cost = cur - startTime;
		// writer.println("Cost in millisec: " + cost);

		writer.flush();

		reader.close();
		writer.close();
	}

}
