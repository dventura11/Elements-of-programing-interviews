import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    String [][] testCases = {
      {"hola", "hola"},
      {"diego","tenoch"},
      {"hola", "mundo"},
      {"Diego", "Danya"},
      {"Mexico", "Monaco"},
      {"andres","andares"}
    };
    for (String[] testCase : testCases) {
      int distance = levenshteinDistance(testCase[0], testCase[1]);
      System.out.printf("%s to %s = %d\n", testCase[0], testCase[1], distance);
    }
  }

  private static int levenshteinDistance(String A, String B) {
    int[][] distance = new int[A.length()+1][B.length()+1];
    for (int i = 0; i <= A.length(); i++) {
      for(int j = 0; j <= B.length(); j++) {
        if ( i == 0) {
          distance[i][j] = j;
          continue;
        }
        if ( j == 0) {
          distance[i][j] = i;
          continue;
        }
        if ( A.charAt(i-1) == B.charAt(j-1) ) {
          distance[i][j] = distance[i-1][j-1];
          continue;
        }
        distance[i][j] = Math.min( distance[i-1][j-1],
            Math.min(distance[i][j-1], distance[i-1][j])
            );
        distance[i][j]++;
      }
    }
    return distance[A.length()][B.length()];
  }

}
