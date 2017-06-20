
public class Main {

  public static void main(String[] args) {
    int[][] in = {
      {1,2,9},
      {1,2,3,9,9,9,9,9,9,9,9},
      {9,9,9,9,9,9,9,9,9,9,9},
      {1,2,3,0,0,0,0,0,0,0,0,0}
    };
    int[][] out = {
      {1,3,0},
      {1,2,4,0,0,0,0,0,0,0,0},
      {1,0,0,0,0,0,0,0,0,0,0,0},
      {1,2,3,0,0,0,0,0,0,0,0,1}
    };

    for (int i = 0; i < in.length; i++) {
      int[] result = plusOne(in[i]);
      System.out.printf("in:\t%s\nout:\t%s\nresult:\t%s\n=============> %b\n",
          printArray(in[i]),
          printArray(out[i]),
          printArray(result),
          compareArrays(out[i], result)
          );
    }
  }

  public static int[] plusOne(final int[] number) {
    int carrie = 1;
    for (int i = number.length - 1; i >= 0; i-- ) {
      if ( carrie == 0 ) break;
      number[i] += carrie;
      carrie = number[i] / 10;
      number[i] %= 10;
    }
    if ( carrie ==0 ) return number;

    int[] result = new int[number.length + 1];
    result[0] = carrie;
    for (int i = 0; i < number.length; i++) result[i+1] = number[i];
    return result;
  }

  public static String printArray(int[] arr) {
    String s = "<";
    for (int i = 0 ; i < arr.length; i++){
      s += arr[i];
      s += i == arr.length - 1 ? ">" : ", ";
    }
    return s;
  }

  public static boolean compareArrays(int[] a, int[] b) {
    if ( a.length != b.length ) return false;
    String s = "<";
    for (int i = 0 ; i < a.length; i++){
      if ( a[i] != b[i]) return false;
    }
    return true;
  }
}
