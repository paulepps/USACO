package Bronze;

import java.io.*;

/**
 * Output:
 * 5 hello
 * 1234 hello
 */
public class PairDemo {
	public static void main(String[] args) throws IOException {
		Pair<Integer, String> p = new Pair<>(5, "hello");
		System.out.println(p.first + " " + p.second);
		p.first = 1234;
		System.out.println(p.first + " " + p.second);
	}
}

class Pair<K, V> {
	K first;
	V second;

	public Pair(K first, V second) {
		this.first = first;
		this.second = second;
	}
}
