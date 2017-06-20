
public class Main {

  public static void main(String[] args) {
    int[][][] in = {
      {
        {2,9,5,7,4,3,0,6,1},
        {4,3,1,8,6,5,9,2,7},
        {8,0,6,1,9,0,5,4,3},
        {3,8,7,4,5,9,2,1,6},
        {6,1,0,3,8,7,4,9,5},
        {5,4,9,2,1,6,7,0,8},
        {7,6,0,5,3,4,1,8,9},
        {9,2,0,6,0,1,3,5,4},
        {1,5,4,9,0,8,6,7,2}
      },
      {
        {2,9,5,7,4,3,8,6,1},
        {4,3,1,8,6,5,9,2,7},
        {8,7,6,1,9,2,5,4,3},
        {3,8,7,4,5,9,2,1,6},
        {6,1,2,3,8,7,4,9,5},
        {5,4,9,2,1,6,7,3,8},
        {7,6,0,5,3,4,1,8,9},
        {9,2,8,6,7,1,3,5,4},
        {1,5,4,9,0,8,6,7,2}
      },
      {
        {2,9,5,7,4,3,8,6,1},
        {4,3,1,8,6,5,9,2,7},
        {8,7,6,1,9,2,5,4,3},
        {3,8,7,4,5,9,2,1,6},
        {6,1,2,3,8,7,4,9,5},
        {5,4,9,2,1,6,7,3,8},
        {7,6,3,5,2,4,1,8,9},
        {9,2,8,6,7,1,3,5,4},
        {1,5,4,9,3,8,6,7,2}
      },
      {
        {2,9,5,7,4,3,8,6,1},
        {4,3,1,8,6,5,9,2,7},
        {8,7,6,1,9,2,5,4,3},
        {3,8,7,4,5,9,2,1,6},
        {6,1,2,3,8,7,4,9,5},
        {5,4,9,2,1,6,7,3,8},
        {7,6,3,5,3,4,1,8,9},
        {9,2,8,6,7,1,3,5,4},
        {1,5,4,9,3,8,6,7,2}
      }
    };
    boolean[] out = {
      true,
      true,
      true,
      false
    };
    for (int i = 0; i < in.length; i++ ) {
      boolean result = isValidsudoku(in[i]);
      System.out.printf("%s\nexpected: %b, result: %b => %b\n", printArray(in[i]), out[i],
          result, out[i] == result);
    }

  }

  public static boolean isValidsudoku(int[][] sudoku) {
    for (int i = 0; i < 9; i++) {
      //check horizontal
      if ( ! isValid( sudoku, 0, 9, i, i+1) ) return false;
      //check vertical
      if ( ! isValid( sudoku, i, i + 1, 0, 9) ) return false;
      //return if is not multipe of 3
      if ( i % 3 != 0) continue;
      //Validate sub squares
      if ( ! isValid( sudoku, i, i+3, 0, 3) ) return false;
      if ( ! isValid( sudoku, i, i+3, 3, 6) ) return false;
      if ( ! isValid( sudoku, i, i+3, 6, 9) ) return false;
    }
    return true;
  }

  private static boolean isValid(int[][] sudoku, int xi, int xf, int yi, int yf) {
    boolean[] exist = new boolean[10];
    for (int y = yi; y < yf; y++) {
      for (int x = xi; x < xf; x++) {
        if ( sudoku[y][x] == 0) continue;
        if ( exist[ sudoku[y][x] ] ) {
          return false;
        }
        exist[ sudoku[y][x] ] = true;
      }
    }
    return true;
  }

  private static String printArray(int[][] sudoku) {
    String s = "";
    for(int[] arr : sudoku) {
      for(int v : arr) {
        s += v + ", ";
      }
      s += "\n";
    }
    return s;
  }
}
