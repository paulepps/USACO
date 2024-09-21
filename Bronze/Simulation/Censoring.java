import java.io.*;

public class Censoring {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("censor.in"));
		PrintWriter pw = new PrintWriter("censor.out");

		String S = r.readLine();
		String T = r.readLine();
		int sLen = S.length();
		int tLen = T.length();

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < sLen; i++) {
			sb.append(S.charAt(i));
			if (sb.length() >= tLen && sb.substring(sb.length() - tLen).equals(T)) {
				sb.delete(sb.length() - tLen, sb.length());
			}
		}
		pw.println(sb);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}