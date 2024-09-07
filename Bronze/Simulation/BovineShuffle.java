import java.io.*;
import java.util.*;

public class BovineShuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter("shuffle.out");

		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] shuffles = new int[N + 1]; 

		st = new StringTokenizer(r.readLine());
		
		for (int i = 1; i <= N; i++) {
			shuffles[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(r.readLine());
		
		String[] cows = new String[N + 1];

		for (int i = 1; i <= N; i++) {
			cows[i] = st.nextToken();
		}

		for (int i = 0; i < 3; i++) {
			String[] cowsCopy = new String[N + 1];

			for (int j = 1; j <= N; j++) {
				cowsCopy[j] = cows[shuffles[j]];
			}

			cows = cowsCopy.clone();
 		}	

		for (int i = 1; i <= N; i++) {
			pw.println(cows[i]);
		}
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}