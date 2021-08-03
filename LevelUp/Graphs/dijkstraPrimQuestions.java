import java.util.Arrays;

public class dijkstraPrimQuestions{
    public int networkDelayTime(int[][] times, int n, int k){
        //{v, w}
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] time : times){
            int u = time[0], v = time[1], w = time[2];
            graph[u].add(new int[]{v, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);

        // {vtx, wsf}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.add(new int[]{k, 0});
        dist[k] = 0;

        while(pq.size() != 0){
            int[] rp = pq.remove();
            int vtx = rp[0], wsf = rp[1];

            if(wsf > dist[vtx]) continue;

            for(int[] e : graph[vtx]){
                int v = e[0], w = e[1];
                if(wsf + w < dist[v]){
                    dist[v] = wsf + w;
                    pq.add(new int[]{v, wsf + w});
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == (int)1e9) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;

    }

    //787 not fully correct(TLE)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] flight : flights){
            int u = time[0], v = time[1], w = time[2];
            graph[u].add(new int[]{v, w});
        }
        // {vtx, cost, edgesCount}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            return a[1] - b[1];
        });
        k++;  //edges ki form me krr rhe h kyuki ham.
        pq.add(new int[] {src, 0, 0});
        while(pq.size() != 0){
            int[] rp = pq.remove();
            int vtx = rp[0], cost = rp[1], edgesCount = rp[2];

            if(edgesCount > k)
               continue;

            if(vtx == dst)
               return cost;
            
            for(int[] e : graph[vtx]){
                int v = e[0], w = e[1];
                pq.add(new int[]{v, cost + w, edgeCount + 1});
            }
        }
        return -1;
    }

}