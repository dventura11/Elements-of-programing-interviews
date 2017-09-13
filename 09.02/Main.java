import java.util.Stack;

public class Main {

  public static void main( String ... args ) {
    String[] in = {
      "2,4,+,2,x,1,+",
      "1,1,+,-1,x",
      "6,3,/,2,/",
      "12,4,+,21,x,4,x,-11,+,-3,x,6,/,4,+",
    };
    int[] out = {
      13,
      -2,
      1,
      -662
    };

    for ( int i = 0; i < in.length; i++ ) {
      int r = evaluareRPN(in[i]);
      System.out.printf("testing: %s, expected: %d, result: %d => %b\n",
          in[i], out[i], r, ( out[i] == r) );
    }

  }

  public static int evaluareRPN(String s) {
    String[] values = s.split(",");
    Stack<String> stack = new Stack<String>();
    for (int i = values.length - 1; i >= 0; i-- ) {
      stack.push(values[i]);
    }
    while ( stack.size() > 1) {
      int v1 = Integer.parseInt(stack.pop());
      int v2 = Integer.parseInt(stack.pop());
      String op = stack.pop();
      switch (op) {
        case "+" :
          v1 += v2;
          break;
        case "-" :
          v1 -= v2;
          break;
        case "x" :
          v1 *= v2;
          break;
        case "/" :
          v1 /= v2;
          break;
      }
      stack.push(String.valueOf(v1));
    }
    return Integer.parseInt(stack.pop());
  }
}
