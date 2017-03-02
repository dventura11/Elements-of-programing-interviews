public class Main {

    private static final int REPEAT = 100000;

    public static void main(String[] args) {
        int[][] cases = {
            {1,1},
            {0,0},
            {10,3},
            {300,17},
            {100000,316},
            {Integer.MAX_VALUE,46340},
        };

        long since = System.currentTimeMillis();
        for (int i = 0; i < REPEAT; i++) {
            for (int[] arr : cases) {
                int result = maxSquareRoot(arr[0]);
                if (result != arr[1]) {
                    System.out.printf("%d was verified and %d  was expected but %d was returned\n", arr[0], arr[1],  result);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - since);

        since = System.currentTimeMillis();
        for (int i = 0; i < REPEAT; i++) {
            for (int[] arr : cases) {
                int result = maxSquareRootBinarySearch(arr[0]);
                if (result != arr[1]) {
                    System.out.printf("%d was verified and %d  was expected but %d was returned\n", arr[0], arr[1],  result);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - since);


    }

    //raiz de n + 1
    public static int maxSquareRoot(int n) {
        long i;
        for (i = 0; (i*i) <= n; i++);
        return (int)i-1;
    }

    //log n
    public static int maxSquareRootBinarySearch(int n) {
        long left = 0, right = n;
        long middle, square;
        while (left <= right) {
            middle = left + ((right - left) / 2);
            square = middle * middle;
            if (square == n) {
                return (int) middle;
            }
            if (square < n) {
                left = middle + 1;
            } else {
                right = middle -1;
            }
        }
        return (int)left-1;
    }

}
