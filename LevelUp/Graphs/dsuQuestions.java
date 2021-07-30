import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class dsuQuestions{
    int[] par, size;
    public int findPar(int u){
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        
        int n = grid.length, m = grid[0].length;
        par = new int[n * m];
        size = new int[n * m];

        int maxSize = 0, count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                par[i * m + j] = i * m + j;
                size[i * m + j] = 1;

                if(grid[i][j] == 1) count++;
            }
        }

        int[][] dir = {{1, 0}, {0, 1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    
                    int p1 = findPar(i * m + j);

                    for(int d = 0; d < 2; d++){
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];

                        if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                            int p2 = findPar(r * m + c);
                            if(p1 != p2){
                                par[p2] = p1;
                                size[p1] += size[p2];
                                count--;          //will be used to count the gcc
                            }
                        }

                    }

                    maxSize = Math.max(maxSize, size[p1]);
                }
            }
        }
        return maxSize;
    }


    public string smallestEquivalentString(String s1, String s2, String baseStr){
        par = new int[26];
        
        for(int i = 0; i < 26; i++){
            par[i] = i;
        }

        for(int i = 0; i < s1.length(); i++){
            int p1 = findPar(s1.charAt(i) - 'a');
            int p2 = findPar(s2.charAt(i) - 'a');

            par[p1] = Math.min(p1, p2);
            par[p2] = Math.min(p1, p2);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            char c = (char) (findPar(baseStr.charAt - 'a') + 'a');
            sb.append(c);

            return sb.toString();
        }
    }

    public boolean isSimilar(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && ++count > 2)
                return false;
        }

        return true;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length, group = n;
        par = new int[n];
        for (int i = 0; i < n; i++)
            par[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    int p1 = findPar(i);
                    int p2 = findPar(j);

                    if (p1 != p2) {
                        par[p1] = p2;
                        group--;
                    }
                }
            }
        }

        return group;
    }

    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        par = new int[n * m];
        Arrays.fill(par, -1);

        int count = 0;
        for (int[] p : positions) {
            int i = p[0], j = p[1];
            if (par[i * m + j] == -1) {
                count++;
                par[i * m + j] = i * m + j;

                int p1 = findPar(i * m + j);
                for (int d = 0; d < dir.length; d++) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && par[r * m + c] != -1) {
                        int p2 = findPar(r * m + c);
                        if (p1 != p2) {
                            count--;
                            par[p2] = p1;
                        }
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }

    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        par = new int[n * m];
        Arrays.fill(par, -1);

        int count = 0;
        for (int[] p : positions) {
            int i = p[0], j = p[1];
            if (par[i * m + j] == -1) {
                count++;
                par[i * m + j] = i * m + j;

                int p1 = findPar(i * m + j);
                for (int d = 0; d < dir.length; d++) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && par[r * m + c] != -1) {
                        int p2 = findPar(r * m + c);
                        if (p1 != p2) {
                            count--;
                            par[p2] = p1;
                        }
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }

    int[] par, size;
    //684
    public int findPar(int u){
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        par = new int[n];
        
        for(int i = 0; i < n; i++){
                par[i] = i;
        }
        
        for(int[] edge : edges){
            int p1 = findPar(edge[0]);
            int p2 = findPar(edge[1]);
            
            if(p1 != p2) par[p1] = p2;
            
            else return edge;
        }
        
        return new int[0];
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes){
        ArrayList<int[]> allPipes = new ArrayList<>();
        for(int[] a : pipes) allPipes.add(a);
        for(int i = 0; i < wells.length; i++){
            allPipes.add(new int[]{0, i + 1, wells[i]});
        }  

        Collections.sort(allPipes, (a,b) ->{
            return a[2] - b[2];
        });

        par = new int[n + 1];
        int ans = 0;
        for(int i = 0; i <= n; i++){
            par[i] = i;
        }

        for(int[] e : allPipes){
            int u = e[0], v = e[1], w = e[2];
            int p1 = findPar(u);
            int p2 = findPar(v);
            if(p1 != p2){
                par[p1] = p2;
                ans += w;
            }
        }
        return ans;
    }

    
    public int mrPresident(int[][] edges, int N, int K) {
        par = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            par[i] = i;
        }

        Arrays.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });

        ArrayList<Integer> roads = new ArrayList<>();

        int components = N, mcost = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int p1 = findPar(u), p2 = findPar(v);
            if (p1 != p2) {
                par[p1] = p2;
                components--;
                mcost += w;
                roads.add(w);
            }
        }

        if (components > 1)
            return -1;

        int superroad = 0;
        for (int i = roads.size() - 1; i >= 0; i--) {
            if (mcost <= K)
                break;
            mcost = mcost - roads.get(i) + 1;
            superroad++;
        }

        return mcost <= K ? superroad : -1;
    }

    //959 Region By slashes
    public int regionsBySlashes(String[] grid) {
        if(grid.length == 0) return 0;
        int n = grid.length, m = n + 1, region = 1;
        
        par = new int[m * m];
        
        for(int i = 0; i < m * m; i++){
            par[i] = i;
            int r = i / m, c = i % m;
            if(r == 0 || c == 0 || r == m - 1 || c == m - 1)
                par[i] = 0;                                   
        }
        
        for(int i = 0; i < n; i++){
            String s = grid[i];
            for(int j = 0; j < s.length(); j++){
                char ch = s.charAt(j);
                int p1 = -10, p2 = -10;  
                if(ch == '/'){
                    p1 = findPar(i * m + j + 1);
                    p2 = findPar((i + 1)* m + j);
                }else if(ch == '\\'){
                    p1 = findPar(i * m + j);
                    p2 = findPar((i + 1)* m + j + 1);
                }else{
                    continue;
                }
                
                if(p1 != p2)
                    par[p1] = p2;
                else
                    region++;
            }
        }
        
        return region;
    }

    //685 Redundant connection 2
                
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int n = edges.length + 1;
            int[] map = new int[n];
            int[] parEdge1 = null;
            int[] parEdge2 = null;
            
            par = new int[n];
            
            for(int i = 0; i < n; i++){
                par[i] = i;
            }
            
            for(int[] edge : edges){
                int p1 = findPar(edge[0]);
                int p2 = findPar(edge[1]);
                
                if(map[p2] > 0){
                    parEdge1 = new int[]{map[p2], p2};
                    parEdge2 = edge;
                }
                    
                map[p2] = p1;
            }
           
            for(int[] edge : edges){
                
                if(parEdge2 == edge) continue;    //Because we need the last ans occuring in the 2D array
                
                int p1 = findPar(edge[0]);
                int p2 = findPar(edge[1]);
                
                if(p1 != p2)
                    par[p2] = p1;
                
                else
                    return parEdge1 == null ? edge : parEdge1; 
            }
            
            return parEdge2;
            
        }
}