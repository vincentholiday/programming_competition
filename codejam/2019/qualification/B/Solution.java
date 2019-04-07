import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

	static void handleCases(int T, BufferedReader reader, PrintWriter writer)
			throws NumberFormatException, IOException {
		String lydia_str = null;

		for (int i = 1; i <= T; ++i) {
			lydia_str = reader.readLine();
			StringBuilder ans_str = new StringBuilder(lydia_str.length());
			for (char c : lydia_str.toCharArray()) {
				if (c == 'E') {
					ans_str.append('S');
				} else {
					ans_str.append('E');
				}
			}
			System.out.printf("Case #%d: %s\n", i, ans_str.toString());
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int T = Integer.parseInt(reader.readLine());
		
		handleCases(T, reader, writer);

		writer.flush();
		reader.close();
		writer.close();
	}

}
