public class Main {

  public static void main (String[] args) {
    int[] in =  {1, 10, 99, 34, 5889, -1, -23930, -1000001, 456, -3434, 1234567890};
    int[] out = {1,  1, 99, 43, 9885, -1,  -3932, -1000001, 654, -4343,  987654321};
    for (int i = 0; i < in.length; i++) {
      int result = reverse(in[i]);
      System.out.printf("Testing: %d\t\texpected: %d\tresult: %d\t%b\n", in[i], out[i], result, (out[i] == result));
    }
  }

  public static int reverse(int n) {
    int r = 0;
    boolean negative = false;
    if ( n < 0 ) {
      negative = true;
      n *= -1;
    }
    while ( n > 0 ) {
      r *= 10;
      r += n % 10;
      n /= 10;
    }
    return negative ? r * -1 : r ;
  }
}
