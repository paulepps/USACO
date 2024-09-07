import java.io.*;
import java.util.*;

public class ShellGame {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("shell.in"));
		PrintWriter pw = new PrintWriter("shell.out");

		int[] shells = new int[3];
		int[] count = new int[3];

		StringTokenizer st = new StringTokenizer(r.readLine());

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			shells[i] = i + 1;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			int temp = shells[a - 1];
			shells[a - 1] = shells[b - 1];
			shells[b - 1] = temp;

			count[shells[g - 1] - 1]++;
		}

		pw.println(Math.max(count[0], Math.max(count[1], count[2])));
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}