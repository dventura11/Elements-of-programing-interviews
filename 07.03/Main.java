
public class Main {

  private static final int BASE = 'Z' - 'A' + 1;

  public static void main(String[] args) {
    String[] in = {"A","D","AA", "ZZ", "Z", "AB", "BA"};
    int[] expectedOutput = {1,4,27,702, 26, 28, 53};
    for (int i = 0; i < in.length; i++) {
      int result = parseSpreadSheetColumnId(in[i]);
      System.out.printf("testing '%s'\texpected: %d\tresult: %d\tvalid: %b\n", in[i], expectedOutput[i], result, (expectedOutput[i] == result));
    }
  }

  public static int parseSpreadSheetColumnId(String sid) {
    int id = 0;
    for (char c : sid.toCharArray()) {
      id *= BASE;
      id += c - 'A' + 1;
    }
    return id;
  }
}
