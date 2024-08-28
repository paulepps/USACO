package General;

import java.io.*;
import java.util.*;

public class PromotionCounting {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("promote.in"));
		PrintWriter pw = new PrintWriter("promote.out");

		r.readLine();

		StringTokenizer st = new StringTokenizer(r.readLine());
		int silverStart = Integer.parseInt(st.nextToken());
		int silverEnd = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(r.readLine());
		int goldStart = Integer.parseInt(st.nextToken());
		int goldEnd = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(r.readLine());
		int platinumStart = Integer.parseInt(st.nextToken());
		int platinumEnd = Integer.parseInt(st.nextToken());

		int goldToPlatinum = platinumEnd - platinumStart;
		int silverToGold = goldEnd - goldStart + goldToPlatinum;
		int bronzeToSilver = silverEnd - silverStart + silverToGold;

		pw.println(bronzeToSilver);
		pw.println(silverToGold);
		pw.println(goldToPlatinum);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}