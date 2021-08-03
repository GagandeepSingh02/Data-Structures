import java.util.list;

public class dijkstraAndPrims {
    public static class pair {
        int vtx, par, w, wsf;

        // for dijikstra1
        pair(int vtx, int par, int w, int wsf) {
            this.vtx = vtx;
            this.par = par;
            this.w = w;
            this.wsf = wsf;
        }

        // for dijikstra2
        pair(int vtx, int wsf) {
            this.vtx = vtx;
            this.wsf = wsf;
        }
    }

    public static void dijikstra_01(ArrayList<Edge>[] graph, int src) {
        int N = graph.length;
        ArrayList<Edge>[] ngraph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            ngraph[i] = new ArrayList<>();

        boolean[] vis = new boolean[N];
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf; // for prims : return a.w - b.w;
        });

        int[] dis = new int[N];
        int[] par = new int[N];

        pq.add(new pair(src, -1, 0, 0));
        while (pq.size() != 0) {
            pair p = pq.remove();

            if (vis[p.vtx])
                continue;

            if (p.par != -1)
                addEdge(ngraph, p.vtx, p.par, p.w);

            vis[p.vtx] = true;

            dis[p.vtx] = p.wsf;
            par[p.vtx] = p.par;

            for (Edge e : graph[p.vtx]) {
                if (!vis[e.v])
                    pq.add(new pair(e.v, p.vtx, e.w, p.wsf + e.w));
            }
        }
    }

    public static void dijikstra_02(ArrayList<Edge>[] graph, int src) {
        int N = graph.length;
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf;
        });

        int[] dis = new int[N];
        int[] par = new int[N];
        Arrays.fill(dis, (int) 1e9);
        Arrays.fill(par, -1);

        pq.add(new pair(src, 0));
        dis[src] = 0;
        while (pq.size() != 0) {
            pair p = pq.remove();

            if (p.wsf > dis[p.vtx])
                continue;

            for (Edge e : graph[p.vtx]) {
                if (p.wsf + e.w < dis[e.v]) {
                    dis[e.v] = p.wsf + e.w;
                    par[e.v] = p.vtx;
                    pq.add(new pair(e.v, p.wsf + e.w));
                }
            }
        }
    }

    public static class primsPair {
        int vtx, w;

        primsPair(int vtx, int w) {
            this.vtx = vtx;
            this.w = w;
        }
    }

    public static void prims(ArrayList<Edge>[] graph, int src) {
        int N = graph.length;
        PriorityQueue<primsPair> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w;
        });

        int[] dis = new int[N];
        Arrays.fill(dis, (int) 1e9);

        pq.add(new primsPair(src, 0));
        dis[src] = 0;
        while (pq.size() != 0) {
            primsPair p = pq.remove();

            if (vis[p.vtx])
                continue;

            vis[p.vtx] = true;
            for (Edge e : graph[p.vtx]) {
                if (e.w < dis[e.v]) {
                    dis[e.v] = e.w;
                    pq.add(new primsPair(e.v, e.w));
                }
            }
        }
    }
}