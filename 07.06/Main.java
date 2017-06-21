public class Main {
  public static void main(String[] args) {
    String[] in = {
      "Alice likes Bob",
      "I am Diego",
      "Hello world",
      "some words in this string ",
      " some others words here",
      "hi"
    };
    String[] out = {
      "Bob likes Alice",
      "Diego am I",
      "world Hello",
      " string this in words some",
      "here words others some ",
      "hi"
    };

    for (int i = 0; i < in.length; i++) {
      String result = reverseWords(in[i]);
      System.out.printf("testing: %s, expected: %s, result: %s => %b\n",
          in[i], out[i], result, ( out[i].equals(result)) );
    }

  }

  public static String reverseWords(String s) {
    String word = "";
    String result = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      word = s.charAt(i) == ' ' ? word + ' ' : s.charAt(i) + word;
      if ( i == 0 || s.charAt(i) == ' ') {
        result += word;
        word = "";
      }
    }
    return result;
  }
}
