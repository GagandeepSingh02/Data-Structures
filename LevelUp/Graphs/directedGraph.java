import java.util.ArrayList;
public class directedGraph{
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
    }

    public static dfs_topo(ArrayList<Edge>[] graph, int src, boolean[vis], ArrayList<Integer> ans){
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
                dfs_topo(graph, e.v, vis, ans);
        }
        ans.add(src);
    }

    public static void topologicalOrder(ArrayList<Edge>[] graph){
        ArrayList<Integer> ans = new ArrayList<>();
        int N = graph.length;
        boolea[] vis = new boolean[N];
        for(int i = 0; i < N; i++){
            if(!vis[i]){
                dfs_topo(graph, i, vis, ans);
            }
        }
    }

    public static ArrayList<Integer> khansAlgoTopo(ArrayList<Edge>[] graph){
        int N = graph.length;
        int[] inOrderDegree = new int[N];
        LinkedList<Integer> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(Edge e : graph[i]){
                inOrderDegree[e.v]++;
            }
        }

        for(int i = 0; i < N; i++){
            if(inOrderDegree[i] == 0)
            que.addLast(i);
        }

        while(que.size() != 0){
            int rvtx = que.removeFirst();
            ans.add(rvtx);

            for(Edge e : graph[rvtx]){
                if(--inOrderDegree[e.v] == 0)
                   que.addLast(e.v);
            }
        }
        if(and.size() != N)
           ans.clear();

           return ans;
    }

        // -1 : unvisited, 0 = currentPath, 1 = backtrack
        public static boolean dfs_topo_isCycle(ArrayList<Edge>[] graph, int src, int[] vis, ArrayList<Integer> ans) {
            vis[src] = 0;
            boolean res = false;
            for (Edge e : graph[src]) {
                if (vis[e.v] == -1) {
                    res = res || dfs_topo_isCycle(graph, e.v, vis, ans);
                } else if (vis[e.v] == 0)
                    return true;
            }
    
            vis[src] = 1;
            ans.add(src);
            return res;
        }
    
        public static ArrayList<Integer> dfs_topo_isCycle(ArrayList<Edge>[] graph) {
            int N = graph.length;
            int[] vis = new int[N];
            Arrays.fill(vis, -1);
            ArrayList<Integer> ans = new ArrayList<>();
    
            boolean cycle = false;
            for (int i = 0; i < N; i++) {
                if (vis[i] == -1) {
                    cycle = cycle || dfs_topo_isCycle(graph, i, vis, ans);
                }
            }
    
            if (cycle)
                ans.clear();
    
            return ans;
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
