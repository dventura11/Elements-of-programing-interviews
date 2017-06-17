import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class FlightNode implements Comparable<FlightNode>{
  String city;
  int cost;
  int connections;
  FlightNode from;
  FlightNode(String city, int cost, int connections, FlightNode from) {
    this.city = city;
    this.cost = cost;
    this.connections = connections;
    this.from = from;
  }
  FlightNode(String city, int cost, int connections) {
    this(city, cost, connections, null);
  }
  FlightNode(String city, int cost) {
    this(city, cost, 0);
  }
  @Override
  public int compareTo(FlightNode n) {
    return this.cost - n.cost;
  }
}

public class Main {
  public static void main(String[] args) {
    String[][] flights = {
      {"San Francisco", "Mexico City", "350"},
      {"San Francisco", "Tokyo", "750"},
      {"San Francisco", "Paris", "670"},
      {"San Francisco", "Moscu", "840"},
      {"San Francisco", "London", "1840"},
      {"Mexico City", "Moscu", "940"},
      {"Mexico City", "London", "940"},
      {"Mexico City", "Tokyo", "630"},
      {"Mexico City", "San Francisco", "230"},
      {"Mexico City", "Paris", "120"},
      {"Mexico City", "Madrid", "450"},
      {"Paris", "Tokyo", "480"},
      {"Paris", "Moscu", "380"},
      {"Paris", "Madrid", "180"},
      {"London", "Tokyo", "880"},
      {"London", "San Francisco", "770"},
      {"London", "Paris", "100"},
      {"Moscu", "Madrid", "520"},
      {"Moscu", "Mexico City", "1000"},
      {"Madrid", "London", "100"},
      {"Madrid", "Paris", "100"},
      {"Madrid", "Mexico City", "600"},
      {"Tokyo", "Moscu", "240"},
      {"Tokyo", "Paris", "540"},
      {"Tokyo", "London", "640"}
    };
    String[][] testCases = {
      {"San Francisco","London", "1", "0"},
      {"San Francisco","London", "2", "0"},
      {"San Francisco","London", "3", "0"},
      {"San Francisco","Tokyo","1", "0"},
      {"San Francisco","Tokyo","2", "0"},
      {"San Francisco","Tokyo","3", "0"},
      {"Mexico City","London", "1", "0"},
      {"Mexico City","London", "2", "0"},
      {"Mexico City","London", "3", "0"},
      {"London","Tokyo", "1", "0"},
      {"London","Tokyo", "2", "0"},
      {"London","Tokyo", "3", "0"},
    };
    Map<String, Set<FlightNode>> graph = new HashMap<String, Set<FlightNode>>();
    for ( String[] entry : flights ) {
      String origin = entry[0];
      String destination = entry[1];
      int cost = Integer.parseInt(entry[2]);
      if ( !graph.containsKey(origin) ) {
        graph.put(origin, new HashSet<FlightNode>());
      }
      graph.get(origin).add(new FlightNode(destination, cost));
    }
    for ( String[] testCase : testCases ) {
      String from = testCase[0];
      String to = testCase[1];
      int max = Integer.parseInt(testCase[2]);
      int expected = Integer.parseInt(testCase[3]);
      FlightNode result = getMinCost(from, to, max, graph);
      System.out.printf("from: %s \tto %s \t with %d connections \t= %d \tand %d was expected (%b)\n", from, to, max, result.cost, expected, (result.cost==expected));
      Stack<FlightNode> stack = new Stack<FlightNode>();
      for (FlightNode current = result; current != null; current = current.from ) stack.push(current);
      while ( !stack.isEmpty() ) {
        FlightNode city = stack.pop();
        System.out.printf("%s ($%d) -> ", city.city, city.cost);
      }
      System.out.println("");
    }
  }
  public static FlightNode getMinCost(String from, String to,int maxConnections, Map<String, Set<FlightNode>> graph) {
    Map<String, FlightNode> answer = new HashMap<String, FlightNode>();
    Queue<FlightNode> heap = new PriorityQueue<FlightNode>();
    heap.add(new FlightNode(from, 0));
    answer.put(from, new FlightNode(from, 0));
    while ( ! heap.isEmpty() ) {
      FlightNode current = heap.poll();
      int connections = current.connections + 1;
      if ( connections > maxConnections ) continue;
      if ( ! graph.containsKey(current.city) ) continue;
      for (FlightNode next : graph.get(current.city) ) {
        int total = current.cost + next.cost;
        FlightNode flight = new FlightNode(next.city, total, connections, current);
        if ( !answer.containsKey(next.city) ) {
          answer.put(next.city, flight);
          heap.add(flight);
          continue;
        }
        if ( total < answer.get(next.city).cost ) {
          answer.put(next.city, flight);
          heap.add(flight);
        }
      }
    }
    return answer.get(to);
  }
}
