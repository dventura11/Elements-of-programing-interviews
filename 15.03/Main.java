import java.io.*;
import java.util.*;

class Main {

  static class Node {
    int data;
    Node left, right;
    Node(int data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    int[][][] testCases = {
      {{19,7,43,3,11,23,47,2,5,17,37,53,13,29,41,31},{23,29}},
      {{10,5,14,3,7,1,4,8,9,14,12,11,13,17,15,19,20}, {16, 17}}
    };
    Node root = null;
    for (int[][] testCase : testCases) {
      root = null;
      for(int data: testCase[0]){
        root = insert(root, data);
      }
      Integer result = closest(root, testCase[1][0]);
      System.out.println(result +  " == " +  testCase[1][1]);
      System.out.println(result == testCase[1][1]);
    }
  }

  public static Integer closest(Node root, int value) {
    Integer result = null;

    while (root != null) {
      if ( root.data > value) {
        result = root.data;
        root = root.left;
      } else {
        root = root.right;
      }
    }

    return result;
  }

  private static Node insert(Node root, int data) {
    if ( root == null ) {
      return new Node(data);
    }
    if ( data < root.data ) {
      root.left = insert(root.left, data);
    } else {
      root.right = insert(root.right, data);
    }
    return root;
  }
}
