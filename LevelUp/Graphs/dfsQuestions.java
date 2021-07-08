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
}