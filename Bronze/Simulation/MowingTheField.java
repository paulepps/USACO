import java.io.*;
import java.util.*;

public class MowingTheField {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("mowing.in"));
		PrintWriter pw = new PrintWriter("mowing.out");

		int max = Integer.MAX_VALUE;	
		int time = 0;

		Map<Cell, Integer> map = new HashMap<>();
		Cell cell = new Cell(0, 0);
		map.put(cell, 0);

		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			char c = st.nextToken().charAt(0);
			int steps = Integer.parseInt(st.nextToken());
			for (int j = 0; j < steps; j++) {
				time++;
				cell = cell.move(c);
				if (map.containsKey(cell)) {
					max = Math.min(max, time - map.get(cell));
				}
				map.put(cell, time);
			}
		}
		pw.println(max == Integer.MAX_VALUE ? -1 : max);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}
}

class Cell {

	int x, y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x * 1000 + y;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Cell))
			return false;
		Cell other = (Cell)o;
		return this.x == other.x && this.y == other.y;
	}
	public Cell move(char c) {
		if (c == 'N') {
			return new Cell(x, y + 1);
		} else if (c == 'E') {
			return new Cell(x + 1, y);
		} else if (c == 'S') {
			return new Cell(x, y - 1);
		} else {
			return new Cell(x - 1, y);
		}
	}
}
