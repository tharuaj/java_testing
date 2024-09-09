
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    static class Edge{
        int src;
        int dst;
        int wt;
        Edge(int s, int d, int w){
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
        Edge(int s, int d){
            this.src = s;
            this.dst = d;
            
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph)
    {
        int n = graph.length;
        for(int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }

/*      graph[0].add(new Edge(0, 2,2));
        
        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-2));

 */
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6,5));
 
    }


    public static void bfs(ArrayList<Edge>[] graph, int v, boolean[] visited,int start)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) 
        {
            int curr = q.remove();
            if(visited[curr] == false)
            {
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int i = 0; i< graph[curr].size();i++)
                {
                    Edge e = graph[curr].get(i);
                    q.add(e.dst);
                }

            }
            
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int cur, boolean visited[])
    {
        System.out.print(cur+ " ");
        visited[cur] = true;

        for(int i = 0; i< graph[cur].size(); i++)
        {
            Edge e = graph[cur].get(i);
            if(visited[e.dst] == false)
            {
                dfs(graph, e.dst, visited);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], boolean vis[],int cur, String path,int tar)
    {
        if(cur == tar)
        { 
            System.out.println(path);
            return;
        }

        for (int i= 0; i < graph[cur].size();i++)
        {
            Edge e = graph[cur].get(i);
            if(vis[e.dst] == false)
            {
                vis[cur] = true;
                printAllPath(graph, vis, e.dst, path+e.dst, tar);
                vis[cur] = false;
            }
        }

    }
    public static void main(String[] args) {
        /* 
        int v = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList [v];
        createGraph(graph);
        
        //j is for source vertex and i is for the adjacent vertex
        for(int j = 0; j<v; j++)
        {
            System.out.println("for Vertex: " +j);
            for(int i = 0; i< graph[j].size();i++)
            {
                Edge e = graph[j].get(i);
                System.out.println("Neighbor: "+ e.dst+ " Weight: "+ e.wt);
                
            }
            System.out.println();
        }
        */
        
        /*      
                1----3
               /     | \
              /      |  \
             0       |   5 -----6
             |       | /
             2-------4  

         */
        int v2 = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph1 = new ArrayList[v2];
        createGraph(graph1);

        boolean[] visited = new boolean[v2];
        System.out.println("BFS");
        for(int i = 0; i<v2; i++)
        {
            if (visited[i] == false)
            {
                bfs(graph1, v2, visited, i);
            }
        }
        System.out.println();

        boolean[] visited1 = new boolean[v2];
        System.out.println("DFS");
        for(int i = 0; i<v2; i++)
        {
            if (visited1[i] == false)
            {
                dfs(graph1, i, visited1);
            }
        }
        

        boolean visited2[] = new boolean[v2];
        int source = 0;
        int target = 5;
        System.out.println("All paths from "+ source+ " to "+ target+ " are: ");
        printAllPath(graph1, visited2, source, "0", target);
        System.out.println();
    }
}
