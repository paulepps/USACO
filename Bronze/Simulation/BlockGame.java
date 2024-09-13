import java.io.*;
import java.util.*;

public class BlockGame {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("blocks.in"));
		PrintWriter pw = new PrintWriter("blocks.out");

		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] letters = new int[26];
		int[] side1 = new int[26];
		int[] side2 = new int[26];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			String word1 = st.nextToken();
			String word2 = st.nextToken();
			for (int j = 0; j < word1.length(); j++) {
				side1[word1.charAt(j) - 'a']++;
			}
			for (int j = 0; j < word2.length(); j++) {
				side2[word2.charAt(j) - 'a']++;
			}

			for (int j = 0; j < 26; j++) {
				letters[j] += Math.max(side1[j], side2[j]);
			}
			Arrays.fill(side1, 0);
			Arrays.fill(side2, 0);
		}
		for (int i = 0; i < 26; i++) {
			pw.println(letters[i]);
		}
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}