import java.io.*;
import java.util.*;

public class MaxFlow {
    private List<Edge>[] edges;

    // Should return the flow between the nodes source and sink in the network.
    // edges[i] is a list of edge to/from the i'th node (both in- and out-going edges)
    public int flow(int V, int E, int source, int sink, List<Edge>[] edges) {
        System.out.printf("source: %d, sink: %d", source, sink);



        return 1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(input.readLine());
        int E = Integer.parseInt(input.readLine());
        List<Edge>[] edges = (List<Edge>[])new LinkedList<?>[V];

        for (int i = 0; i < V; i++) {
            edges[i] = new LinkedList<Edge>();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer tokens = new StringTokenizer(input.readLine());

            Edge edge = new Edge();
            edge.from = Integer.parseInt(tokens.nextToken());
            edge.to = Integer.parseInt(tokens.nextToken());
            edge.capacity = Integer.parseInt(tokens.nextToken());

            edges[edge.from].add(edge);
            edges[edge.to].add(edge);
        }

        System.out.println(new MaxFlow().flow(V, E, 0, 1, edges));
    }
}

class Edge {
    public int from;
    public int to;
    public int capacity;
    public int flow;        // Residual graph
    public int reverseEdge; // Residual graph
}