/**
 * Because the road segments and Bessie's driving speeds don't coincide
 * in a predictable way, the way to solve the problem is to model the
 * road and Bessie’s journey mile by mile. We can then compare Bessie’s 
 * speed with the speed limit for every mile of the 100-mile road.
 */
import java.io.*;
import java.util.*;

public class SpeedingTicket {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("speeding.in"));
		PrintWriter pw = new PrintWriter(" speeding.out");

		// Divide the road into 100 segments
		int[] speedLimits = new int[100];
		int[] speeds = new int[100];

		int pos = 0;
		int max = 0;

		// Read and parse input
		StringTokenizer st = new StringTokenizer(r.readLine());

		// Number of road segments
		int N = Integer.parseInt(st.nextToken());

		// Number of segments Bessie drives
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());

			// For each road segment, read the miles and speed limit
			int miles = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());

			// Fill the speedLimits array with the speed limit for each mile
			for (int j = 0; j < miles; j++, pos++) {
				speedLimits[pos] = speed;
			}
		}

		pos = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(r.readLine());

			// For each segment Bessie drives, read the miles and speed
			int miles = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());

			// Fill the speeds array with Bessie's speed for each mile
			for (int j = 0; j < miles; j++, pos++) {
				speeds[pos] = speed;
			}
		}

		// Compare Bessie's speed with the speed limit for each mile
		for (int i = 0; i < 100; i++) {
			if (speeds[i] > speedLimits[i]) {
				// Keep track of the maximum excess speed (if any)
				max = Math.max(max, speeds[i] - speedLimits[i]);
			}
		}

		// Output the result
		pw.println(max);

		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}