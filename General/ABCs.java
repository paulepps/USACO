package General;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ABCs {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

        List<Integer> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(r.readLine());

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int A = list.get(0);
        int target = list.get(list.size() - 1) - A;

        int low = 1;
        int high = list.size() - 2;

        while (list.get(low) + list.get(high) != target) {
            if (list.get(low) + list.get(high) < target) {
                low++;
            } else {
                high--;
            }
        }
        pw.print(A + " " + list.get(low) + " " + list.get(high));
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
        r.close();
	}
}
