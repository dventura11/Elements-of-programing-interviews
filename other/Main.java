import java.util.Arrays;

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
    if (s1.length() < s2.length()) {
      String temp = s1;
      s1 = s2;
      s2 = temp;
    }
    while (s2.length() < s1.length()) s2 = "0"+s2;
    char[] answer = new char[s1.length() + 1];
    char c1, c2;
    for(int writeIndex = answer.length-1 ; writeIndex > 0; writeIndex--) {
      c1 = s1.charAt(writeIndex-1);
      c2 = s2.charAt(writeIndex-1);
      if (c1 == c2) {
        answer[writeIndex] = answer[writeIndex] == '1' ? '1' : '0';
        if (c1 == '1') {
          answer[writeIndex-1] = '1';
        }
      } else if (answer[writeIndex] == '1') {
        answer[writeIndex] =  '0';
        answer[writeIndex-1] =  '1';
      } else {
        answer[writeIndex] ='1';
      }
    }
    return String.valueOf( answer[0] == '1' ? answer : Arrays.copyOfRange(answer, 1, answer.length) );
  }
}
