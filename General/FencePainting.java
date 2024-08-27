package General;
import java.io.*;
import java.util.*;

public class FencePainting {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("paint.in")));
		PrintWriter pw = new PrintWriter("paint.out");

		StringTokenizer st = new StringTokenizer(r.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		
        r.close();

        int result = b - a;
        
        if (c < a) {
            if (d < a) {
                result += d - c;
            } else if (d > b) {
                result = d - c;
            } else {
                result += a - c;
            }
        } else if (c > b) {
            result += d - c;
        } else {
            if (d > b) {
                result += d - b;
           }
        }
        pw.println(result);
        pw.close();
    }
}
