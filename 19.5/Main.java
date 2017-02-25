import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //case minimally conected
        /*/
        int[][] edges = {
            {3, 4},
            {7, 8},
            {0, 1},
            {2, 1},
            {7, 4},
            {4, 5},
            {6, 3},
            {9, 6},
            {3, 1}
        };
        /*/
        int[][] edges = {
            {3, 4},
            {7, 8},
            {0, 1},
            {2, 1},
            {7, 4},
            {4, 5},
            {6, 3},
            {7, 6},
            {9, 6},
            {8, 5},
            {3, 1}
        };
        /**/
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for (int[] edge : edges) {
            for(int vertice : edge) {
                if( ! graph.containsKey(vertice) ) {
                    graph.put(vertice, new HashSet<Integer>());
                }
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.printf("graph: %s \n is minimally conected? r: %b\n", graph.toString(), isMinimallyConected(graph));
    }

    public static boolean isMinimallyConected(Map<Integer,Set<Integer>> graph) {
        Set<Integer> visited = new HashSet<Integer>();
        if (graph.isEmpty()) {
            return true;
        }

        int first = graph.keySet().iterator().next();
        boolean minimallyConected = isMinimallyConected(graph, visited, first, null);

        if ( !minimallyConected ) {
            return false;
        }

        for(Integer vertice : graph.keySet()) {
            if ( !visited.contains(vertice) ) {
                return false;
            }
        }
        return true;
    };

    private static boolean isMinimallyConected(Map<Integer,Set<Integer>> graph, Set<Integer> visited, int vertice, Integer origin) {
        if ( visited.contains(vertice) ) {
            return false;
        }
        visited.add(vertice);
        for(Integer current : graph.get(vertice)) {
            if (current == origin) {
                continue;
            }
            if ( !isMinimallyConected(graph, visited, current, vertice)) {
                return false;
            }
        }
        return true;
    }
}
