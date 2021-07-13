import java.util.LinkedList;

public class bfsQuestions {

    public int orangesRotting(int[][] grid) {
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int freshOranges = 0, time = 0, n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    freshOranges++;
                else if (grid[i][j] == 2) {
                    que.addLast(i * m + j);
                    grid[i][j] = 2; // mark them visited
                }
            }
        }

        if (freshOranges == 0)
            return 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rottedOrangeIDX = que.removeFirst();
                int sr = rottedOrangeIDX / m, sc = rottedOrangeIDX % m;
                for (int d = 0; d < 4; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                        if (--freshOranges == 0)
                            return time + 1;
                        grid[r][c] = 2;
                        que.addLast(r * m + c);
                    }
                }
            }
            time++;
        }

        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;

        int n = grid.length, m = grid[0].length , shortestPath = 1;
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1) 
           return -1;

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(0);
        int[][] dir ={{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int idx = que.removeFirst();
                int sr = idx / m, sc = idx % m;

                if(sr == n - 1 && sc == m - 1) return shortestPath;

                for(int d = 0; d < dir.length; d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 0){
                        grid[r][c] = 1;
                        que.addLast(r * m + c);
                    }
                }
                
            }
            shortestPath++;
        }
        return -1;
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n][m];
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(grid[0][0]);
        int[][] dir ={{1,0},{1,-1},{0,-1},{-1,-1}};
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int idx = que.removeFirst();
                int sr = idx / m, sc = idx % m;
                for(int d = 0; d < dir; d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if(r >= 0 && c >= 0 && r < n, c < m && grid[i][j] == 1){
                        que.addLast(r * m + c);
                        grid[r][c] = 2;
                    }
                    if(grid[r][c] = 0)
                }
            }
        }
        return count + 1;
    }

    public static void wallsAndGates(int[][] rooms){
        if(rooms.length == 0 || rooms[0].length == 0)
           return rooms;
        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0 , -1}};
           
        int n = grid.length, m = grid[0].length;
        LinkedList<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rooms[i][j] == 0){
                    que.addLast(i * m + j);
                }
            }
        }
        while(que.size() != 0){
            int idx = que.removeFirst();
                int sr = idx / m, sc = idx % m;
                for(int d = 0; d < 4; d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]){
                        vis[r][c] = true;
                        que.addLast(r * m + c);
                        rooms[r][c] = rooms[r][c] + 1;
                    }
            }
        }
        return rooms;
    } 

}