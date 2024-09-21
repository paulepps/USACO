import java.io.*;
import java.util.*;

public class MilkMeasurement {
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter("measurement.out");

        Map<String, Integer> cowIndexMap = new HashMap<>();
        cowIndexMap.put("Bessie", 0);
        cowIndexMap.put("Elsie", 1);
        cowIndexMap.put("Mildred", 2);

        int[] milk = new int[3];
        milk[0] = 7;
        milk[1] = 7;
        milk[2] = 7;

		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());

        List<Measurement> measurements = new ArrayList<>();            
		
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            int day = Integer.parseInt(st.nextToken());
            String cow = st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            measurements.add(new Measurement(day, cow, change));
        }

        measurements.sort((a, b) -> a.day - b.day);

        boolean[] maxMilkCows = new boolean[3];
        Arrays.fill(maxMilkCows, true);

        int maxMilkChange = 0;

        for (Measurement m : measurements) {
            // Update appropriate cow
            milk[cowIndexMap.get(m.cow)] += m.change;

            // Find the new max milk
            int maxMilk = milk[0];
            for (int i = 1; i < 3; i++) {
                if (milk[i] > maxMilk) {
                    maxMilk = milk[i];
                }
            }

            // Find new winners
            boolean[] newMaxMilkCows = new boolean[3];
            for (int i = 0; i < 3; i++) {
                if (milk[i] == maxMilk) {
                    newMaxMilkCows[i] = true;
                }
            }

            // Check if the max milk cows have changed
            if (!eq(maxMilkCows, newMaxMilkCows)) {
                maxMilkChange++;
                maxMilkCows = newMaxMilkCows;
            }
        }
        
        pw.println(maxMilkChange);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}

    // returns true iff a and b are all equal, must be same lengths.
	public static boolean eq(boolean[] a, boolean[] b) {
		for (int i=0; i<a.length; i++)
			if (a[i] != b[i])
				return false;
		return true;
	}
}

class Measurement {
    int day;
    String cow;
    int change;

    public Measurement(int day, String cow, int change) {
        this.day = day;
        this.cow = cow;
        this.change = change;
    }
}