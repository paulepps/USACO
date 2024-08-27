import java.io.*;

public class FileIO {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		long x = Long.parseLong(r.readLine());
		while (x != 1) {
			pw.print(x + " ");
			if (x % 2 == 0) {
				x /= 2;
			} else {
				x = 3 * x + 1;
			}
		}
		pw.println(x);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
	}
}