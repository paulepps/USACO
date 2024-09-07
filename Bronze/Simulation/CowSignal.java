package Bronze.Simulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowSignal {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cowsignal.in"));
		PrintWriter pw = new PrintWriter("cowsignal.out");

        StringTokenizer st = new StringTokenizer(r.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            String line = r.readLine();
            String bigLine = "";
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < K; k++) {
                    bigLine += line.charAt(j);
                }
            }
            for (int k = 0; k < K; k++) {
                pw.println(bigLine);
            }
    }
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
    
}
