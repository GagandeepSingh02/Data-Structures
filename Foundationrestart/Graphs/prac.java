import java.util.ArrayList;
public class prac{
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

    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static void display(){
        for(int i = 0; i < N; i++){
            System.out.print(i + " -> ");
            for(Edge e : graph[i]){
            System.out.print(e);
            }
            System.out.println();
        }
    }

    public static int findEdge(int u, int v){
        for(int i = 0; i < graph[u].size(); i++){
            Edge e = graph[u].get(i);
            if(e.v == v)
            return i;
        }
        return -1;
    }
    public static void removeEdge(int u, int v){
        int idx1 = findEdge(u,v);
        int idx2 = findEdge(v,u);
        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVtx(int u){
        while(graph[u].size() != 0){
            int n = graph[u].size() - 1;
            Edge e = graph[u].get(n);
            removeEdge(u,e.v);
        }
    }

    public static boolean hasPath(int src, int dest, boolean[] vis){
        if(src == dest) return true;
        boolean res = false;
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
            res = res || hasPath(e.v, dest, vis);
            }
        }
        return res;
    }


    public static void printPreOrder(int src, boolean[] vis, String ans, int wsf){
        System.out.println(src + "->" + ans + src + "@" + wsf);
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                printPreOrder(e.v,vis,ans+src,wsf + e.w);
            }
        } 
        vis[src] = false;
    }

    public static void printPostorder(int src, boolean[] vis, String ans, int wsf){
        vis[src] = true;

        for (Edge e : graph[src]) {
            if (!vis[e.v])
                printPostOrder(e.v, vis, ans + src, wsf + e.w);
        }

        System.out.println(src + " -> " + ans + src + " @ " + wsf);
        vis[src] = false;
    }

    
    public static int allPath(int src, int dest, boolean[] vis, String ans){
        if(src == dest){
            System.out.println(ans + dest);
            return 1;
        }
        int count = 0;
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                count += allPath(e.v,dest,vis,ans+src);
            }
        }
        vis[src] = false;
        return count;
    }

    public static class pair {
        int largestWeight = -(int) 1e9;
        String largestPath = "";
        int smallestWeight = (int) 1e9;
        String smallestPath = "";

        int ceil = (int) 1e9;
        String ceilPath = "";
        int floor = -(int) 1e9;
        String floorPath = "";

    }

    public static class pqPair {
        int wsf = 0;
        String psf = "";

        pqPair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }
    }

    static PriorityQueue<pqPair> pq = new PriorityQueue<>((a, b) -> {
        return a.wsf - b.wsf;
    });

    public static void allSolution(int src, int dest, boolean[] vis, pair p, String psf, int wsf, int givenWeight,int k) {

        if (src == dest) {
            if (wsf > p.largestWeight) {
                p.largestWeight = wsf;
                p.largestPath = psf + dest;
            }

            if (wsf < p.smallestWeight) {
                p.smallestWeight = wsf;
                p.smallestPath = psf + dest;
            }

            if (wsf < givenWeight)
                if (wsf > p.floor) {
                    p.floor = wsf;
                    p.floorPath = psf + dest;
                }
            if (wsf > givenWeight)
                if (wsf < p.ceil) {
                    p.ceil = wsf;
                    p.ceilPath = psf + dest;
                }

            pq.add(new pqPair(wsf, psf + dest));
            if (pq.size() > k)
                pq.remove();

            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                allSolution(e.v, dest, vis, p, psf + src, wsf + e.w, givenWeight, k);
        }

        vis[src] = false;
    }

    public static void dfs(int src,boolean[] vis){
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
            dfs(e.v, vis);
        }
    }
    public static void gcc(int src){
        boolean[] vis = new boolean[N];
        for(int i = 0; i < N; i++){
            if(!vis[i]){
                components++;
                dfs(i,vis);
            }
        }
    }

     public static void main(String[] args) {
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        addEdge(0, 1, 10);
        addEdge(0, 3, 40);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 2);
        addEdge(4, 5, 3);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);
        
        display();

        //System.out.println(findEdge(2,3));
        boolean[] vis = new boolean[N];
        allPath(0,4,vis,"");
        printPreOrder(0,vis,"",0);
        pair p = new pair();
        allSolution(0, 6, vis, p, "", 0, 30, 4);
        System.out.println("Smallest Path =" + p.smallestPath + "@" +
        p.smallestWeight);
        System.out.println("Largest Path =" + p.largestPath + "@" + p.largestWeight);
        System.out.println("Ceil of 30 =" + +p.ceil);
        System.out.println("Floor of 30 =" + +p.floor);
        System.out.println("Kth Largest Path =" + pq.peek().psf + "@" +
        pq.peek().wsf);
     }

} 
