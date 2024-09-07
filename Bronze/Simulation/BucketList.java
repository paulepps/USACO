import java.io.*;
import java.util.*;

public class BucketList {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("blist.in"));
		PrintWriter pw = new PrintWriter("blist.out");

        int[] buckets = new int[1001];

		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                buckets[j] += b;
            }
        }

		pw.println(Arrays.stream(buckets).max().getAsInt());
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}