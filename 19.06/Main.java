import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Copy Graph
 */
public class Main {

    private static class Vertex {
        Vertex(String label) {
            this.label = label;
            edges = new ArrayList<Vertex>();
        }
        String label;
        List<Vertex> edges;

        public String toString() {
            return this.label;
        }
    }

    public static void main(String[] args) {
        String[][] edges = {
            {"0", "1"},
            {"2", "3"},
            {"3", "4"},
            {"7", "8"},
            {"1", "2"},
            {"7", "4"},
            {"4", "5"},
            {"3", "6"},
            {"6", "7"},
            {"6", "9"},
            {"9", "5"},
            {"8", "5"},
            {"3", "1"}
        };

        Map<String, Vertex> graph = new HashMap<String, Vertex>();
        for (String[] edge : edges) {
            if ( !graph.containsKey(edge[0]) ) {
                graph.put(edge[0], new Vertex(edge[0]) );
            }
            if ( !graph.containsKey(edge[1]) ) {
                graph.put(edge[1], new Vertex(edge[1]) );
            }
            graph.get(edge[0]).edges.add(graph.get(edge[1]) );
        }
        String VertexName = graph.keySet().iterator().next();
        Vertex v = graph.get(VertexName);
        printVertexValues(v, new HashSet<Vertex>());
        System.out.println("");
        Vertex u = cloneVertex(v, new HashMap<String, Vertex>());
        printVertexValues(u, new HashSet<Vertex>());
        System.out.println("");
    }

    public static Vertex cloneVertex(Vertex v, Map<String, Vertex> copied) {
        Vertex u = new Vertex(v.label);
        copied.put(u.label, u);
        for(Vertex edge : v.edges) {
            Vertex copiedEdge =  (copied.containsKey(edge.label)) ? copied.get(edge.label) : cloneVertex(edge, copied);
            u.edges.add(copiedEdge);
        }
        return u;
    }

    private static void printVertexValues(Vertex v, Set<Vertex> visited) {
        System.out.print(v + ", ");
        if (visited.contains(v)) {
            return;
        }
        visited.add(v);
        for(Vertex edge : v.edges) {
            printVertexValues(edge, visited);
        }
    }

}
