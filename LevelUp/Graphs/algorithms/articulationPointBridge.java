public class articulationPointBridge{

    public static class Edge {
        int v = 0, w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int[] low, disc;
    static boolean[] articulation, vis;
    static int time = 0, rootCalls = 0;

    public static void dfs(ArrayList<Edge>[] graph, int src, int par){
        disc[src] = low[src] = time++;
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                if(par == -1)
                  rootCalls++;

                dfs(graph, e.v, src);
                if(disc[src] <= low[e.v])
                     articulation[src] = true;
                if(disc[src] < low[e.v])
                     System.out.println("Articulation Edge: " +  src + " " + e.v);     

                low[src] = Math.min(low[src], low[e.v]);

            }else if(e.v != par){
                low[src] = Math.min(low[src], disc[e.v]);
            }
        }
    }
    public static void articulationPointAndBridges(ArrayList<Edge>[] graph){
        int N = graph.length;
        low = new int[N];
        disc = new int[N];
        articulation = new boolean[N];
        vis = new boolean[N];

        for(int i = 0; i < N; i++){
            if(!vis[i]){
                dfs(graph, i, -1);
            }
        }
    }
}