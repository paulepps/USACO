package General;

import java.io.*;
import java.util.*;

public class WordProcessor {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("word.in"));
		PrintWriter pw = new PrintWriter("word.out");

		StringTokenizer st = new StringTokenizer(r.readLine());

		st.nextToken();
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(r.readLine());

		int lineSize = 0;

		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			if (lineSize + word.length() > K) {
				pw.println();
				lineSize = 0;
			} else if (lineSize > 0) {
				pw.print(" ");
			}
			pw.print(word);
			lineSize += word.length();
		}
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}