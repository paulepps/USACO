import java.io.*;
import java.util.*;

class Pair<K, V> {
	K first;
	V second;

	public Pair(K first, V second) {
		this.first = first;
		this.second = second;
	}
}

public class TeamTicTacToe {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter pw = new PrintWriter("tttt.out");

		int singleWinners = 0;
		int teamWinners = 0;
		char[][] board = new char[3][3];
		
		for (int i = 0; i < 3; i++) {
			String line = r.readLine().toUpperCase();
			for (int j = 0; j < 3; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		Set<Character> set = new HashSet<>();
		List<Pair<Character, Character>> pairs = new ArrayList<>();
		List<Character> singles = new ArrayList<>();

		// Check rows
		for (int i = 0; i < 3; i++) {
			set.clear();
			for (int j = 0; j < 3; j++) {
				set.add(board[i][j]);
			}
			if (set.size() == 1) {
				if (!singles.contains(board[i][0])) {
					singleWinners++;
					singles.add(board[i][0]);
				}
			} else if (set.size() == 2) {
				if (newPair(set, pairs)) {
					teamWinners++;
				}
			}
		}

		// Check columns
		for (int i = 0; i < 3; i++) {
			set.clear();
			for (int j = 0; j < 3; j++) {
				set.add(board[j][i]);
			}
			if (set.size() == 1) {
				if (!singles.contains(board[0][i])) {
					singleWinners++;
					singles.add(board[0][i]);
				}
			} else if (set.size() == 2) {
				if (newPair(set, pairs)) {
					teamWinners++;
				}
			}
		}

		// Check diagonals
		set.clear();
		for (int i = 0; i < 3; i++) {
			set.add(board[i][i]);
		}
		if (set.size() == 1) {
			if (!singles.contains(board[0][0])) {
				singleWinners++;
				singles.add(board[0][0]);
			}
		} else if (set.size() == 2) {
			if (newPair(set, pairs)) {
				teamWinners++;
			}
		}

		set.clear();
		for (int i = 0; i < 3; i++) {
			set.add(board[i][2 - i]);
		}
		if (set.size() == 1) {
			if (!singles.contains(board[0][2])) {
				singleWinners++;
				singles.add(board[0][2]);
			}
		} else if (set.size() == 2) {
			if (newPair(set, pairs)) {
				teamWinners++;
			}
		}

		pw.println(singleWinners);
		pw.println(teamWinners);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
		r.close();
	}

	private static boolean newPair(Set<Character> set, 
			List<Pair<Character, Character>> pairs) {
		Object[] array = set.toArray();
		Pair<Character, Character> p = 
			new Pair<>((Character)array[0], (Character)array[1]);
		for (Pair<Character, Character> pair : pairs) {
			if (pair.first == p.first && pair.second == p.second 
					|| pair.first == p.second && pair.second == p.first) {
				return false;
			}
		}
		pairs.add(p);
		return true;
	}
}