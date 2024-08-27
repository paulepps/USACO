package General;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Teleportation {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter pw = new PrintWriter("teleport.out");

		StringTokenizer st = new StringTokenizer(r.readLine());

        int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

        int result = Math.abs(a - b);
        int result2 = Math.abs(a - x) + Math.abs(b - y);
        int result3 = Math.abs(a - y) + Math.abs(b - x);

        pw.print(Math.min(result, Math.min(result2, result3)));
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
        r.close();
	}
}
