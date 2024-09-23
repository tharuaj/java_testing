import java.util.ArrayList;
import java.util.PriorityQueue;

public class Algo{
    static class Edge{
        int src;
        int dst;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
        public Edge(int s, int d){
            this.src = s;
            this.dst = d;
            
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        
        for (int i =0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    public static void createGraph1(ArrayList<Edge> graph[]){
        
        for (int i =0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }
        @Override
        public int compareTo(Pair p){
            return this.dist - p.dist;//ascending order
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];

        int dist[] = new int[V];
        for (int i = 0; i<V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(src, 0));

        while(! pq.isEmpty()){
            Pair cur = pq.remove();
                vis[cur.node] = true;

                for(int i = 0; i< graph[cur.node].size();i++){
                    Edge e = graph[cur.node].get(i);
                    int u = e.src;
                    int v = e.dst;

                    if(dist[u]+e.wt < dist[v]){
                        dist[v] = dist[u]+e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
        }
        
        //print the distance
        for(int i = 0; i< V; i++){
            System.out.println("The Dijkstra shortest distance from "+ src+ " to node "
            + i+ " is: "+ dist[i]);
        }
        System.out.println();
        
    }
    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V){
        int dist[] = new int[V];
        for(int i = 0; i< V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i<V-1; i++){
            for(int j = 0; j<V; j++){
                for(int k = 0; k<graph[j].size();k++){
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dst;
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+ e.wt < dist[v]){
                        dist[v] = dist[u]+ e.wt;
                    }
                }
            }
        }
        for(int i = 0; i< V; i++){
            System.out.println("The Bellman shortest distance from "+ src+ " to node "
            + i+ " is: "+ dist[i]);
        }
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int src, int V){
        boolean visited[] = new boolean[V];     
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int[] parent = new int[V];  // To store the parent of each node in MST
        ArrayList<Edge> mstEdges = new ArrayList<>(); 
        
        int cost = 0;
        parent[src] = -1; 

        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair cur = pq.remove();
            if(!visited[cur.node]){
                visited[cur.node] = true;
                cost += cur.dist;
                if (parent[cur.node] != -1) {
                    mstEdges.add(new Edge(parent[cur.node], cur.node, cur.dist));
                }
                for(int i = 0; i<graph[cur.node].size();i++){
                    Edge e = graph[cur.node].get(i);
                    
                    if(!visited[e.dst]){
                        pq.add(new Pair(e.dst, e.wt));
                        parent[e.dst] = cur.node;
                    }
                }
            }
        }

        System.out.println("Minimum Spanning Tree cost: "+cost);
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mstEdges) {
            System.out.println("Edge: " + edge.src + " - " + edge.dst);
        }
    }

    public static void main(String[] args) {
        int V = 6;

        System.out.println("Dijkstra Algorithm--------------------------------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0, V);
        

        System.out.println("Bellman Ford Algorithm----------------------------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph1[] = new ArrayList[V];
        createGraph1(graph1);
        bellmanFord(graph1, 0, 5);

        System.out.println();
        System.out.println("Prim's Algorithm----------------------------------");
        primsAlgo(graph, 0, V);
        
    }

}

