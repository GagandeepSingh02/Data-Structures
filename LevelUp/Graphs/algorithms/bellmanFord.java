public class bellmanFord {
    public static void bellmanFordAlgo(int n, int[][] edges, int src){
        int[] prev = new int[N];
        int[] curr = new int[N];
        int[] temp = new int[N];

        Arrays.fill(prev, (int) 1e9);
        Arrays.fill(curr, (int) 1e9);

        prev[src] = curr[src] = 0;
        boolean negativeCycle = false;
        for(int i = 1; i <= N; i++){
            boolean anyUpdate = false;
            for(int[] e : edges){
                int u = e[0], v = e[1], w = e[2];
                if(prev[u] != (int) 1e9 && prev[u] + w < curr[v]){
                    curr[v] = prev[u] + w;
                    anyUpdate = true;
                    if(i == N) {
                        negativeCycle = true;
                        break;
                    }
                 }        
            }
            if(!anyUpdate)
               break;

            for(int j = 0; j < N; j++)
                temp[j] = curr[j];
            prev = temp;
        }

        return curr;
    }
}