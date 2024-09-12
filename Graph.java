
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        graph[0].add(new Edge(0, 1,3));
        graph[0].add(new Edge(0,2,5));

        graph[1].add(new Edge(1,0,3));
        graph[1].add(new Edge(1,3,2));

        graph[2].add(new Edge(2,0,5));
        graph[2].add(new Edge(2,4,2));
        

        graph[3].add(new Edge(3,1,2));
        graph[3].add(new Edge(3,4,7));
        graph[3].add(new Edge(3,5,3));

        graph[4].add(new Edge(4, 2,2));
        graph[4].add(new Edge(4, 3,7));
        graph[4].add(new Edge(4, 5,4));

        graph[5].add(new Edge(5, 3,3));
        graph[5].add(new Edge(5, 4,4));
        graph[5].add(new Edge(5, 6,1));

        graph[6].add(new Edge(6,5,1));
 
    }
//--------------------------------------------------------------------------------
    public static void bfs(ArrayList<Edge>[] graph, int start, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) 
        {
            int cur = q.remove();
            if(visited[cur] == false)
            {
                System.out.print(cur + " ");
                visited[cur] = true;

                for(int i = 0; i< graph[cur].size();i++)
                {
                    Edge e = graph[cur].get(i);
                    q.add(e.dst);
                }

            }
            
        }
    }
//----------------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------
    public static boolean isCycledUndirected(ArrayList<Edge> graph[], int cur, boolean vis[], int par)
    {
        vis[cur]= true;
        for( int i = 0; i< graph[cur].size();i++)
        {
            Edge e = graph[cur].get(i);
            if(vis[e.dst] && e.dst != par)
            {
                return true;
            }
            else if(!vis[e.dst] && isCycledUndirected (graph, e.dst, vis, cur))
            {
                return true;
            }
        }

        return false;
    }
//------------------------------------------------------------------------------
    public static void printAllPath(ArrayList<Edge> graph[] ,int cur, boolean vis[], String path,int tar,int distance)
    {
        
        if(cur == tar)
        { 
            System.out.println("Path: "+ path);
            System.out.println("Distance: "+ distance);
            return;
        }

        for (int i= 0; i < graph[cur].size();i++)
        {
            Edge e = graph[cur].get(i);
            if(vis[e.dst] == false)
            {
                
                vis[cur] = true;
                printAllPath(graph, e.dst, vis, path+e.dst, tar,distance+e.wt);
                
                vis[cur] = false;
            }
        }

    }
//-------------------------------------------------------------------------------
    public static void topSortUtil(ArrayList<Edge> graph[], int cur, boolean vis[], Stack<Integer> stack)
    {
        vis[cur] = true;

        for(int i = 0; i< graph[cur].size();i++)
        {
            Edge e = graph[cur].get(i);

            if(!vis[e.dst])
            {
                topSortUtil(graph, e.dst, vis, stack);
            }
        }
        stack.push(cur);
    }

    public static void topSort(ArrayList<Edge> graph[], int v)
    {
        boolean vis[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<v; i++)
        {
            if(!vis[i])
            {
                topSortUtil(graph, i, vis, stack);
            }
        }
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
//-----------------------------------------------------------------------------
    public static void main(String[] args) {
        
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
//----------------------------------------------------------------------------------
        boolean[] visited = new boolean[v2];
        System.out.println("BFS");
        for(int i = 0; i<v2; i++)
        {
            if (visited[i] == false)
            {
                bfs(graph1, i, visited);
            }
        }
        System.out.println();
        System.out.println();
//---------------------------------------------------------------------------------
        boolean[] visited1 = new boolean[v2];
        System.out.println("DFS");
        for(int i = 0; i<v2; i++)
        {
            if (visited1[i] == false)
            {
                dfs(graph1, i, visited1);
            }
        }
        System.out.println();
        System.out.println(); 
//-----------------------------------------------------------------------------------
        boolean visited2[] = new boolean[v2];
        int source = 0;
        int distance = 0;
        int target = 5;

        System.out.println("Using DFS, All paths from "+ source+ " to "+ target+ " are: ");
        printAllPath(graph1, source, visited2,  "0", target,distance);
        System.out.println();
//------------------------------------------------------------------------------------
        boolean vis[] = new boolean[v2];

        for (int i = 0; i < v2; i++)
        {
            if(!vis[i])
            {
                boolean cycled = isCycledUndirected(graph1, source, vis, -1);
                if(cycled)
                {
                    System.out.println("Graph contains cycle");
                    break;
                }
            }
        }
        System.out.println();
//---------------------------------------------------------------------------------
        System.out.print("The topological sort is: ");
        topSort(graph1, v2);
        System.out.println();
        
    }
}
