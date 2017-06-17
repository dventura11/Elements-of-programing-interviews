import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    String[] dictionary = {
      "tierno",
      "tiempo",
      "termo",
      "techo",
      "hola",
      "perro",
      "casa",
      "cama",
      "colchon",
      "limon",
      "leon"
    };
    List<Character> order = getOrder(dictionary);
    for ( char c : order) System.out.print(c + ", ");
    System.out.println();
  }

  public static List<Character> getOrder(String[] dictionary) {
    List<Character> order = new ArrayList<Character>();
    Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
    String last = null;
    for (String word : dictionary) {
      System.out.println(word);
      for ( int i = 0; last != null && i < last.length() && i < word.length(); i++ ) {
        char cChar = word.charAt(i);
        char lChar = last.charAt(i);
        if ( cChar != lChar) {
          if ( !graph.containsKey(cChar) ) {
            graph.put(cChar, new HashSet<Character>());
          }
          if ( !graph.containsKey(lChar) ) {
            graph.put(lChar, new HashSet<Character>());
          }
          graph.get(cChar).add(lChar);
          break;
        }
      }
      last = word;
    }
    while ( !graph.isEmpty() ) {
      for (Character key : graph.keySet() ) {
        if ( graph.get(key).isEmpty() ) {
          order.add(key);
          System.out.print(key);
          System.out.println(" -> " + graph.keySet());
        }
        graph.get(key).removeAll(order);
      }
      for (Character key : order) graph.remove(key);
    }
    return order;
  }
}
