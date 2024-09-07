package Bronze.Simulation;

import java.io.*;
import java.util.*;

public class SpeedingTicket {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("speeding.in"));
		PrintWriter pw = new PrintWriter("speeding.out");

		int[] speedLimits = new int[100];
		int[] speeds = new int[100];

		int pos = 0;
		int max = 0;

		StringTokenizer st = new StringTokenizer(r.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			int miles = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());

			for (int j = 0; j < miles; j++, pos++) {
				speedLimits[pos] = speed;
			}
		}

		pos = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(r.readLine());
			int miles = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());

			for (int j = 0; j < miles; j++, pos++) {
				speeds[pos] = speed;
			}
		}

		for (int i = 0; i < 100; i++) {
			if (speeds[i] > speedLimits[i]) {
				max = Math.max(max, speeds[i] - speedLimits[i]);
			}
		}
		pw.println(max);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}