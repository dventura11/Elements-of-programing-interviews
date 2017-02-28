import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Star implements Comparable<Star> {
        int x, y , z, distance;
        Star(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.distance = Math.abs(x) + Math.abs(y) + Math.abs(z);
        }

        public int compareTo(Star s) {
            return s.distance - this.distance;
        }

        public String toString() {
            return String.format("x: %d, y: %d, z: %d\tdistance: %d", this.x, this.y, this.z, this.distance);
        }
    }

    public static void main(String[] args) throws Exception {
        File f = new File("stars.in");
        Star[] closest = findClosest(5, f);
        for (Star s : closest) {
            System.out.println(s);
        }
    }

    public static Star[] findClosest(int k, File source) throws IOException {
        Scanner in = new Scanner(source);
        Queue<Star> closest = new PriorityQueue<Star>();
        while (in.hasNext() ) {
            closest.add( new Star(in.nextInt(), in.nextInt(), in.nextInt() ) );
            if ( closest.size() > k ) {
                closest.poll();
            }
        }
        in.close();
        Star[] result = new Star[closest.size()];
        for (int i = closest.size() - 1; i >= 0; i-- ) {
            result[i] = closest.poll();
        }
        return result;
    }
}
