import java.io.*;
import java.util.*;

public class CircularBarn {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter pw = new PrintWriter("cbarn.out");

		StringTokenizer st = new StringTokenizer(r.readLine());
		int n = Integer.parseInt(st.nextToken());

		int[] cows = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(r.readLine());
			cows[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				int index = (i + j) % n;
				sum += j * cows[index];
			}
			min = Math.min(min, sum);
		}
		pw.println(min);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
} 