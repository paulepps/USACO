import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StuckInARut {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());

        List<Cow> east = new ArrayList<>();
        List<Cow> north = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            char dir = st.nextToken().charAt(0);

            if (dir == 'E') {
                east.add(new Cow(Integer.parseInt(st.nextToken()), 
                                    Integer.parseInt(st.nextToken()), i));
            } else {
                north.add(new Cow(Integer.parseInt(st.nextToken()), 
                                    Integer.parseInt(st.nextToken()), i));
            }
        }

        Collections.sort(north, new XComparator());
        Collections.sort(east, new YComparator());

        for (Cow cowEast : east) {
            if (cowEast.stopped) {
                continue;
            }

            for (Cow cowNorth : north) {
                if (cowNorth.stopped) {
                    continue;
                }
                if (cowEast.x > cowNorth.x || cowEast.y < cowNorth.y) {
                    // will not intersect
                    continue;
                }
                int x = cowNorth.x - cowEast.x;
                int y = cowEast.y - cowNorth.y;

                if (x < y) { // east stops north
                    cowNorth.stopped = true;
                    cowNorth.cells = y;
                }
                if (y < x) { // north stops east
                    cowEast.stopped = true;
                    cowEast.cells = x;
                    break;
                }
            }
        }
        List<Cow> listAll = Stream.concat(east.stream(), north.stream())
                            .collect(Collectors.toList());
        Collections.sort(listAll, new IndexComparator());
        
        for (Cow cow : listAll) {
            if (cow.cells == -1) {
                pw.println("Infinity");
            } else {
                pw.println(cow.cells);
            }
        }
        
        pw.close();
    }

    static class Cow {
        int x, y, cells, index;
        boolean stopped;

        Cow(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.cells = -1;
            this.stopped = false;
        }
    }

    static class XComparator implements java.util.Comparator<Cow> {
        @Override
        public int compare(Cow a, Cow b) {
            return a.x - b.x;
        }
    }

    static class YComparator implements java.util.Comparator<Cow> {
        @Override
        public int compare(Cow a, Cow b) {
            return a.y - b.y;
        }
    }

    static class IndexComparator implements java.util.Comparator<Cow> {
        @Override
        public int compare(Cow a, Cow b) {
            return a.index - b.index;
        }
    }
}