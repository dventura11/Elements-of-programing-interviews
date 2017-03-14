
public class Main {

  public static void main(String[] args) {
    int[][] testCases = {
      {1,2,3,4}
    };
    for (int[] testCase : testCases) {
      printPermutations(testCase, 0);
    }
  }
  public static void printPermutations(int[] data, int index) {
    if (index == data.length) {
      for(int v: data) System.out.print(v);
      System.out.println("");
      return;
    }
    for (int i = index; i < data.length; i++) {
      swap(data, index, i);
      printPermutations(data,index+1);
      swap(data, i, index);
    }
  }

  private static void swap(int[] data, int a, int b) {
    if (data[a] == data[b]) return;
    data[a] ^= data[b];
    data[b] ^= data[a];
    data[a] ^= data[b];
  }
}
