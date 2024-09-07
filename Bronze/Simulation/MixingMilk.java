package Bronze.Simulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MixingMilk {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("mixmilk.in"));
		PrintWriter pw = new PrintWriter("mixmilk.out");

        StringTokenizer st;
        int[] capacities = new int[3];
        int[] units = new int[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(r.readLine());
            capacities[i] = Integer.parseInt(st.nextToken());
            units[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 100; i++) {
            int from = i % 3;
            int to = (i + 1) % 3;
            int pour = Math.min(units[from], capacities[to] - units[to]);

            units[from] -= pour;
            units[to] += pour;
        }

        pw.print(String.format("%d\n%d\n%d", units[0], units[1], units[2]));
    
   		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
}
}
