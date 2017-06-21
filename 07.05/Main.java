public class Main {

  public static void main (String[] args) {
    String[] in = {
      "A man, a plan, a canal, Panama",
      "Able was I, ere I saw Elba!",
      "Ray a Ray",
      "Anita lava la tina",
      "Sol y luna",
      "  #@$%  ^$  #  # # ^  % & ^* & %^$# ?>,  /.  }{ ",
      "  #@$%  ^$  #  # # ^ m  % & ^* & %^$# ?>,  /.  }{ ",
      "  #@$%  ^$  #  # # ^ mm  % & ^* & %^$# ?>,  /.  }{ ",
    };
    boolean[] out = {
      true,
      true,
      false,
      true,
      false,
      true,
      true,
      true
    };
    for (int i = 0; i < in.length; i++) {
      boolean result = isPalindromic(in[i]);
      System.out.printf("testing: %s, expected: %b, result: %b => %b\n",
          in[i], out[i], result, (out[i] == result) );
    }
  }
  public static boolean isPalindromic(String s) {
    int i = 0;
    int j = s.length() -1;
    s = s.toUpperCase();
    while ( i < j ) {
      while ( i < s.length() && ( s.charAt(i) < 'A' || s.charAt(i) > 'Z' ) ) i++;
      while ( j > 0 && ( s.charAt(j) < 'A' || s.charAt(j) > 'Z' ) ) j--;
      if ( i >= s.length() || j <= 0) break;
      if ( s.charAt(i) != s.charAt(j) ) return false;
      i++;
      j--;
    }
    return true;
  }
}
