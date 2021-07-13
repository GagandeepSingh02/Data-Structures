import java.util.HashSet;
public class dfsQuestions{
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
           return 0;
       }
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

       int numIslands = 0;
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               if (grid[i][j] == '1') {
                   numIslands++;
                   dfs_Island(grid, dir, i, j);
               } 
           }
       }
       return numIslands;
   }
    public void dfs_Island(char[][] grid,int[][] dir, int i , int j) {   
        
        grid[i][j] = '0';   //kuch bhi mark krr skte h jo array me na ho.
       for (int d = 0; d < 4; d++) {
           int r = i + dir[d][0];
           int c = j + dir[d][1];

           if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1') {
               dfs_Island(grid, dir, r, c);
           }
       }      
   }

   //=========================================================================================================
   public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
      
       int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                  int count=dfs(grid,dir,i,j);
                    max=Math.max(count,max);
                }
            }
        }
        return max;
        }
    
    public int dfs(int[][] grid,int[][] dir,int i,int j){
        grid[i][j]=0;
        int count=0;
        for(int d=0;d<4;d++){
            int r=i+dir[d][0];
            int c=j+dir[d][1];
            
            if(r>=0&&c>=0&&r<grid.length&&c<grid[0].length&&grid[r][c]==1){
               count+= dfs(grid,dir,r,c);
            }
        }
        return count+1;
    }

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dir = { { 1, 0 }, { 0, 1 } };

        int onceCount = 0, nbrCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 2; d++) {
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];

                        if (r < n && c < m && grid[r][c] == 1)
                            nbrCount++;
                    }
                }
            }
        }
        return 4 * onceCount - 2 * nbrCount;
    }

    // 130
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    surrounded_DFS(board, i, j, dir);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '$')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
    
    public void surrounded_DFS(char[][] grid, int i, int j, int[][] dir) {
        grid[i][j] = '$';
        int n = grid.length, m = grid[0].length;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 'O')
                surrounded_DFS(grid, r, c, dir);
        }

    }

     public void numberofDistinctIslands(int[][] grid, int[][] dir, String[] sDir, int n, int m, int i, int j, StringBuilder sb){
        grid[i][j] = '0';

        for(int d = 0; d < 4; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
             if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                sb.append(sDir[d]);
                numberofDistinctIslands(grid, dir, sDir, n, m, r, c, sb);
                sb.append("b");
            }
        }
    }
     
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        HashSet<String> set = new HashSet<>();
         int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        String[] sDir = {"D", "U", "R", "L" };
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    numberofDistinctIslands(grid, dir, sDir, n, m, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public boolean countSubIslands(int[][] grid1, int[][] grid2, int i, int j, int n, int m, int[][] dir){
        grid2[i][j] = 0;
        boolean res = true;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid2[r][c] == 1) {
                res = countSubIslands(grid1, grid2, r, c, n, m, dir) && res;
            }
        }

        return res && grid1[i][j] == 1;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int count = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    count += countSubIslands(grid1, grid2, i, j, n , m, dir) ? 1 : 0;
                }
            }
        }

        return count;
    }
}