import java.io.*;
import java.util.*;

class Main {

  private static final int[] X = {0,0,-1,1,1,1,-1,-1};
  private static final int[] Y = {1,-1,0,0,1,-1,1,-1};

  public static void main(String[] args) {
    printNonAttackingPlacements(1);
    printNonAttackingPlacements(2);
    printNonAttackingPlacements(3);
    printNonAttackingPlacements(4);
    printNonAttackingPlacements(9);
    printNonAttackingPlacements(12);
  }

  public static void printNonAttackingPlacements(int n) {
    int[][] board= new int[n][n];
    printNonAttackingPlacements(board, 0);
  }

  private static void printNonAttackingPlacements(int[][] board, int n) {
    if (n == board.length) {
      printSolution(board);
      return;
    }
    for(int i = 0; i < board.length; i++) {
      if (board[n][i] == 0) {
        int[][] boardCopy = copyArray(board);
        disableSpaces(boardCopy, n, i);
        printNonAttackingPlacements(boardCopy, n+1);
      }
    }
  }

  private static void disableSpaces(int[][] board, int a, int b) {
    board[a][b] = 1;
    int x,y;
    for (int i = 0; i < X.length; i++) {
      x = a + X[i];
      y = b + Y[i];
      while (x >= 0 && y >= 0 && x < board.length && y < board.length ){
        if (board[x][y] == 0) {
          board[x][y] = -1;
        }
        x += X[i];
        y += Y[i];
      }
    }
  }

  private static int[][] copyArray(int[][] board) {
    int[][] copy = new int[board.length][board.length];
    for (int i = 0; i < board.length; i++) {
      for(int j = 0; j < board.length; j++) {
        copy[i][j] = board[i][j];
      }
    }
    return copy;
  }

  private static void printSolution(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      System.out.print("|");
      for(int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] == 1 ? "X|" : "_|");
      }
      System.out.println("");
    }
    System.out.println("==============================");
  }

}
