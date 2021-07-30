import java.util.ArrayList;
public class graphPractice{
    public static class Edge{
        int v = 0;
        int w = 0;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public String toString(){
            return "(" + this.v + ", " + this.w + ")";
        }
    }

    public static void display(ArrayList<Edge>[] graph){
        int n = graph.length;
        for(int i = 0; i < n; i++){
            System.out.print( i + " -> " );
            for(Edge e : graph[i]){
                System.out.print(e);
            }
            System.out.println();
        }
    
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w){
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static int findEdge(ArrayList<Edge>[] graph, int u, int v){
        ArrayList<Edge> list = graph[u];
        for(int i = 0; i < list.size(); i++){
            Edge e = list.get(i);
            if(e.v == v){
                return i;
            }
        }
        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v){
        int idx = findEdge(graph, u, v);
        graph[u].remove(idx);

        idx = findEdge(graph, v, u);
        graph[v].remove(idx);
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if(src == dest) return true;
        vis[src] = true;
        boolean res = false;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                res = res || hasPath(graph, e.v, dest, vis);
            }
        }
        return res;
    }

    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String psf, int wsf, boolean[] vis){
        if(src == dest){
            System.out.println(psf + dest + " @ " + wsf);
        }
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
               printAllPath(graph, e.v, dest, psf + src, wsf + e.w, vis);
        }
        vis[src] = false;
    }

    public static void gcc_Dfs(ArrayList<Edge>[] graph, int src, boolean[] vis){

        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
              gcc_Dfs(graph, e.v, vis);
        }
    }

    public static void getConnectedComponent(ArrayList<Edge>[] graph){
        int N = graph.length;
        boolean[] vis = new boolean[N];
        int components = 0;
        for(int i = 0; i < N; i++){
            if(!vis[i]){
                gcc_Dfs(graph, i, vis);
                components++;
            }

        }
        System.out.println(components);
    }

    public static void constructGraph(){
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 0, 10);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 5, 6, 3);
        addEdge(graph, 6, 4, 8);
        //display(graph);
        getConnectedComponent(graph);
    }

    public static void main(String[] args){
        constructGraph();
    }
}