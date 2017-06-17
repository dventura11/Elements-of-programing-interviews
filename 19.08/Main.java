import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Set<String> dictionary = new HashSet<String>();
    dictionary.add("bat");
    dictionary.add("cot");
    dictionary.add("dog");
    dictionary.add("dag");
    dictionary.add("dot");
    dictionary.add("cat");
    String[][] testCases = {
      {"bat","cat"},
      {"bat","dag"},
      {"bat","dog"},
      {"dot","dag"},
      {"dog","cot"},
    };
    int[] expected = {
      1,
      5,
      4,
      2,
      2
    };
    int result;
    for (int i = 0; i < expected.length; i++) {
      result = transformString(testCases[i][0], testCases[i][1], dictionary);
      System.out.printf("%s to %s\t result: %d expected: %d\t%b\n",
          testCases[i][0],testCases[i][1], result, expected[i],
          (result == expected[i]) );
    }
  }

  public static int transformString(String s, String t, Set<String> dictionary) {
    Map<String, Set<String>> graph = generateMap(dictionary);
    Map<String, Integer> distance = new HashMap<String, Integer>();
    Queue<String> queue = new LinkedList<String>();
    String current;
    queue.add(s);
    distance.put(s, 0);
    while ( !queue.isEmpty() ) {
      current = queue.poll();
      if (current.equals(t)) {
        return distance.get(current);
      }
      for (String edge : graph.get(current)) {
        if (distance.containsKey(edge) ) continue;
        queue.add(edge);
        distance.put(edge, distance.get(current) + 1 );
      }
    }
    return -1;
  }

  private static Map<String, Set<String>> generateMap(Set<String> dictionary) {
    Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
    for (String s : dictionary) {
      for(String t : dictionary) {
        if ( s.equals(t) ) continue;
        if ( !onlyOneDifferent(s, t) ) continue;
        if ( !graph.containsKey(s) ) {
          graph.put(s, new HashSet<String>());
        }
        graph.get(s).add(t);
      }
    }
    return graph;
  }

  private static boolean onlyOneDifferent(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    boolean different = false;
    for (int i = 0; i < s.length(); i++) {
      if ( s.charAt(i) != t.charAt(i) ) {
        if (different) return false;
        different = true;
      }
    }
    return true;
  }

}
