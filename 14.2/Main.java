
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    int[][][] testCases = {
      { {1, 2, 3, 5, 6, 8, 9 , 0, 0, 0, 0} , {1,2,3,5} } ,
      { {4,5,6,7,0,0,0},{1,2,3}},
      { {1,2,3,4,0,0,0,0}, {5,6,7,8}},
      { {1,2,3,4,0,0,0,0}, {1,2,3,4} },
      { { 1,2,3,3,3,0,0,0,0}, {3,3,3,4}}
    };
    for (int[][] testCase : testCases) {
      int[] a = testCase[0];
      int[] b = testCase[1];
      mergeSortInPlace(a, b);
      int last = Integer.MIN_VALUE;
      for (int temp : a) {
        System.out.print(temp + ", ");
        if ( temp < last) {
          System.out.println("fail");
        }
        last = temp;
      }
      System.out.println("\ndone");
    }
  }

  public static void mergeSortInPlace(int[] a, int[] b) {
    int writeIndex = a.length - 1;
    int i = a.length - 1;
    while ( a[i] == 0 ) i--;
    int j = b.length - 1;
    int swap;
    while ( i >= 0 && j >= 0) {
      a[writeIndex--] = ( b[j] >= a[i]) ? b[j--] : a[i--];
    }
    while ( j >= 0) {
      a[writeIndex--] = b[j--];
    }
  }
}

