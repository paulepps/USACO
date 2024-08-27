import java.io.*;
import java.util.*;

public class FileIO {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("problemname.in"));
		PrintWriter pw = new PrintWriter("problemname.out");

		StringTokenizer st = new StringTokenizer(r.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		pw.print("The sum of these three numbers is ");
		pw.println(a + b + c);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
	}
}