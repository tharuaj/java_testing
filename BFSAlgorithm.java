import java.util.*;

public class BFSAlgorithm 
{

    // Function to perform BFS on the entire graph
    public static void BFS(Map<Integer, List<Integer>> graph) 
    {
        // Distance map: Stores distance of each node from the start
        Map<Integer, Integer> distance = new HashMap<>();
        // Visit order map: Stores the order in which nodes are visited
        Map<Integer, Integer> visitOrder = new HashMap<>();
        // Visited edges set
        Set<Edge> B = new HashSet<>();

        // Initialize all nodes' distance and visit order to infinity (represented by -1 here)
        for (int u : graph.keySet()) 
        {
            distance.put(u, Integer.MAX_VALUE);  // Infinite distance
            visitOrder.put(u, Integer.MAX_VALUE);  // Infinite visit order
        }

        int i = 0;  // Counter for visit order

        // Traverse all nodes in the graph
        for (int v : graph.keySet()) 
        {
            if (distance.get(v) == Integer.MAX_VALUE) 
            {  // If node v is not visited
                i = BFS_VISIT(graph, v, i, distance, visitOrder, B);
            }
        }

        // Print the BFS result
        System.out.println("Visit Order: " + visitOrder);
        System.out.println("Visited Edges: " + B);
    }

    // Function to perform BFS from a given node 's'
    public static int BFS_VISIT(Map<Integer, List<Integer>> graph, int s, int i,
                                Map<Integer, Integer> distance, Map<Integer, Integer> visitOrder, Set<Edge> B) 
    {
        Queue<Integer> Q = new LinkedList<>();
        distance.put(s, 0);  // Starting node has distance 0
        Q.add(s);  // Enqueue starting node

        while (!Q.isEmpty()) 
        {
            int u = Q.poll();  // Dequeue
            i = i + 1;  // Increment visit order counter
            visitOrder.put(u, i);  // Mark the visit order of node u

            // Explore all neighbors of u
            for (int v : graph.get(u)) 
            {
                if (distance.get(v) == Integer.MAX_VALUE) 
                {  // If neighbor v is unvisited
                    distance.put(v, distance.get(u) + 1);  // Update distance
                    B.add(new Edge(u, v));  // Add edge to set B
                    Q.add(v);  // Enqueue neighbor v
                }
            }
        }

        return i;  // Return updated visit order counter
    }

    // Helper class to represent edges
    static class Edge {
        int u, v;

        Edge(int u, int v) 
        {
            this.u = u;
            this.v = v;
        }

        @Override
        public String toString() 
        {
            return "(" + u + ", " + v + ")";
        }

        @Override
        public boolean equals(Object o) 
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return u == edge.u && v == edge.v;
        }

        @Override
        public int hashCode() 
        {
            return Objects.hash(u, v);
        }
    }

    // Example usage
    public static void main(String[] args) 
    {
        // Define the graph as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, Arrays.asList(1, 2));
        graph.put(5, Arrays.asList(3));

        // Call BFS
        BFS(graph);
    }
}
