package General;

import java.io.*;

public class BucketBrigade {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("buckets.in"));
		PrintWriter pw = new PrintWriter("buckets.out");

		char[][] grid = new char[10][10];
		int[] barn = new int[2];
		int[] rock = new int[2];
		int[] lake = new int[2];

		for (int i = 0; i < 10; i++) {
			String line = r.readLine();
			for (int j = 0; j < 10; j++) {
				grid[i][j] = line.charAt(j);
				if (grid[i][j] == 'B') {
					barn[0] = i;
					barn[1] = j;
				} else if (grid[i][j] == 'R') {
					rock[0] = i;
					rock[1] = j;
				} else if (grid[i][j] == 'L') {
					lake[0] = i;
					lake[1] = j;
				}
			}
		}

		if (barn[0] == rock[0] && rock[0] == lake[0] && ((barn[1] < rock[1] && rock[1] < lake[1]) || (barn[1] > rock[1] && rock[1] > lake[1]))) {
			pw.print(Math.abs(barn[1] - lake[1]) + 1);
		} else if (barn[1] == rock[1] && rock[1] == lake[1] && ((barn[0] < rock[0] && rock[0] < lake[0]) || (barn[0] > rock[0] && rock[0] > lake[0]))) {
			pw.print(Math.abs(barn[0] - lake[0]) + 1);
		} else {
			pw.print(Math.abs(barn[0] - lake[0]) + Math.abs(barn[1] - lake[1]) - 1);
		}
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}