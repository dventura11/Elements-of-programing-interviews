import java.util.*;

public class Diego {

    static class Point {
        Point back;
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Point(int x, int y, Point back) {
            this(x,y);
            this.back = back;
        }
        @Override
        public int hashCode() {
            return (this.x+1)*(this.y+1);
        }
        @Override
        public boolean equals (Object o) {
            if ( o == null) return false;
            if  (o instanceof Point) {
                Point p = (Point)o;
                return  p.x == this.x && p.y == this.y;
            }
            return false;
        }
    }

    private static int[] mx = {1,0,-1,0};
    private static int[] my = {0,1,0,-1};

    public static Collection<Point> findPath(boolean[][] maze, Point entrance, Set<Point> exits) {
        if (exits.contains(entrance))
            return getPath(entrance);
        Queue<Point> points = new ArrayDeque<Point>();
        points.add(entrance);
        int i,nextX, nextY;

        while (points.size() > 0) {
            Point current = points.poll();
            for ( i = 0; i < 4; i++) {
                nextX = current.x + mx[i];
                nextY = current.y + my[i];
                if ( nextX < 0 || nextX >= maze.length || nextY < 0 || nextY >= maze[0].length)
                    continue;
                if ( maze[nextY][nextX]) {
                    Point n = new Point(nextX,nextY, current);
                    if (exits.contains(n))
                        return getPath(n);
                    points.add(n);
                    maze[nextY][nextX] = false;
                }

            }
        }
        return null;
    }

    private static Collection<Point> getPath(Point p) {
        Queue<Point> path = new ArrayDeque<Point>();
        for (Point current = p; current != null; current = current.back)
            path.add(current);
        return path;
    }

    public static void main(String ... str) {
        boolean[][] maze = new boolean[][]{
            {false, true, true,true,true,true, false, false, true, true},
            {true, true, false,true,true,true, true, true, true, true},
            {false, true, false,true,true,false, false, true, false, false},
            {true, true, true,false,false,false, true, true, false, true},
            {true, false, false,true,true,true, true, true, true, true},
            {true, false, false,true,true,false, true, false, false, true},
            {true, true, true,true,false,true, true, true, true, true},
            {false, true, false,true,false,true, false, true, true, true},
            {false, true, false,false,true,true, true, false, false, false},
            {true, true, true,true,true,true, true, false, false, true},
        };
        Set<Point> exits = new HashSet<Point>();
        exits.add(new Point(9,0));
        exits.add(new Point(9,9));
        Collection<Point> path = findPath(maze, new Point(0,9), exits);
        for (Point p : path) {
            System.out.println(String.format("step in [%d,%d]", p.x, p.y));
        }
    }
}
