
public class CountPaths {

    public static void main(String ... args) {
        boolean[][] grid = {
            {false, false, false, false, false, false, false, false},
            {false, false, true , false, false, true , false, false},
            {false, true , false, false, false, true , false, false},
            {false, false, false, true , false, false, true , false},
            {false, false, false, false, true , false, false, false},
            {false, true , true , false, true , false, false, false},
            {false, true , false, false, false, false, false, false},
            {false, false, false, false, false, true , false, false},
            {false, false, false, false, false, false, false, false}
        };
            System.out.println(count(grid));
    }

    private static int count(final boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]paths = new int[n][m];
        paths[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if ( grid[i][j] ) {
                    continue;
                }
                if ( i > 0 ) {
                    paths[i][j] += paths[i-1][j];
                }
                if ( j > 0 ) {
                    paths[i][j] += paths[i][j-1];
                }
            }
        }

        return paths[n-1][m-1];
    }
}
