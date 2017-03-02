public class Main {

    public static void main(String[] args) {
        int[][] cases = {
            {1,1},
            {0,0},
            {10,3},
            {300,17},
            {100000,316},
            {Integer.MAX_VALUE,46340},
        };

        for (int[] arr : cases) {
            int result = maxSquareRoot(arr[0]);
            System.out.printf("Verifing %d...\n", arr[0]);
            if (result != arr[1]) {
                System.out.printf("expected: %d and %d was returned\n",  arr[1],  result);
            }
        }
    }

    public static int maxSquareRoot(int n) {
        long i;
        for (i = 0; (i*i) <= n; i++);
        return (int)i-1;
    }
}
