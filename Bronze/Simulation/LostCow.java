import java.io.*;
import java.util.*;

public class LostCow {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("lostcow.in"));
		PrintWriter pw = new PrintWriter("lostcow.out");

		StringTokenizer st = new StringTokenizer(r.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int distance = 0;
		int pos = x;

		int move = 1;
		int dir = 1;

		while (true) {
			if (dir == 1) {
				if (pos <= y && y <= x + move) {
					distance += y - pos;
					break;
				} else {
					distance += (x + move) - pos;
					pos = x + move;
					dir = -1;
				}
			} else {
				if (x - move <= y && y <= pos) {
					distance += pos - y;
					break;
				} else {
					distance += pos - (x - move);
					pos = x - move;
					dir = 1;
				}
			}
			move *= 2;
		}

		pw.println(distance);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}