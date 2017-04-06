
public class Main {

  public static void main (String[] args) {
    String[][] testCases = {
      {"1", "0", "1"},
      {"1000000", "11111", "1011111"},
      {"111", "11", "1010"},
      {"1", "11111", "100000"},
    };
    for (String[] testCase : testCases) {
      String result = add(testCase[0], testCase[1]);
      System.out.printf("%s + %s => %s == %s\t%b\n", testCase[0], testCase[1], testCase[2], result, (testCase[2].equals(result) ) );
    }
  }

  public static String add(String s1, String s2) {
    StringBuilder result = new StringBuilder();
    int i      = s1.length();
    int j      = s2.length();
    int carrier = 0;
    while ( i-- > 0 | j-- > 0 || carrier == 1 ) {
      carrier += i >= 0 ? s1.charAt(i) - '0' : 0;
      carrier += j >= 0 ? s2.charAt(j) - '0' : 0;
      result.insert(0,carrier%2);
      carrier >>= 1;
    }
    return result.toString();
  }
}
