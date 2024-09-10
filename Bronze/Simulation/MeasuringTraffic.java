import java.io.*;
import java.util.*;

public class MeasuringTraffic {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("traffic.in"));
		PrintWriter pw = new PrintWriter("traffic.out");
		PrintWriter console = new PrintWriter(System.out);

		class Sensor {
			int low;
			int high;
			String type;
			Sensor(int low, int high, String type) {
				this.low = low;
				this.high = high;
				this.type = type;
			}
		}

		int low = 0;
		int high = (int)1e9;

		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());

		Sensor[] sensors = new Sensor[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			String type = st.nextToken();
			int lo = Integer.parseInt(st.nextToken());
			int hi = Integer.parseInt(st.nextToken());
			sensors[i] = new Sensor(lo, hi, type);
		}

		for (int i = N - 1; i >= 0; i--) {
			String type = sensors[i].type;
			int lo = sensors[i].low;
			int hi = sensors[i].high;

			if (type.equals("on")) {
				low -= hi;
				high -= lo;
				// Set to zero if negative
				low = Math.max(0, low);
			} else if (type.equals("off")) {
				low += lo;
				high += hi;
			} else {
				low = Math.max(low, lo);
				high = Math.min(high, hi);
			}
		}

		pw.printf("%d %d\n", low, high);

		for (int i = 0; i < N; i++) {	
			String type = sensors[i].type;
			int lo = sensors[i].low;
			int hi = sensors[i].high;

			if (type.equals("on")) {
				low += lo;
				high += hi;
			} else if (type.equals("off")) {
				low -= hi;
				high -= lo;
				// Set to zero if negative
				low = Math.max(0, low);
			} else {
				low = Math.max(low, lo);
				high = Math.min(high, hi);
			}
		}

		pw.printf("%d %d\n", low, high);

		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}