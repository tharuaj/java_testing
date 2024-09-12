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
            if(!vis[cur.node]){
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
        }

        for(int i : dist){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0, V);
        
    }


}
