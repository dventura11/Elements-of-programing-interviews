import java.io.*;
import java.util.*;

class Main {

  static class Node {
    int data;
    Node left, right;
    Node (int data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    int[] data = {19,7,43,3,11,23,47,2,5,17,37,53,13,29,41,31};
    Node root = null;
    for (int v : data) {
      root = insert(root, v);
    }
    System.out.println("should print 53");
    printKlarguestElements(root, 1);
    System.out.println("should print 53,47,43,41,37");
    printKlarguestElements(root, 5);
    System.out.println("should print 53,47,43,41,37,31,29,23,19,17");
    printKlarguestElements(root, 10);
  }

  public static void printKlarguestElements(Node root, int k) {
    printKElements(root, k);
    System.out.println("");
  }
  public static int printKElements(Node root, int k) {
    if (root == null) return k;
    if ( k <= 0 ) return k;
    k = printKElements(root.right, k);
    if ( k <= 0 ) return k;
    System.out.print(root.data + ", ");
    return printKElements(root.left, --k);
  }

  private static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    }
    if (root.data > data) {
      root.left = insert(root.left, data);
    } else {
      root.right = insert(root.right, data);
    }
    return root;
  }
}
