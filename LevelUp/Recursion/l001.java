import java.util.Arrays;
public class l001{
    public static int floodFill(int sr, int sc, int er, int ec, int[][] dir, boolean[][] vis, String[] dirS, String psf){
        if(sr == er && sc == ec){
            System.out.println(psf);
            return 1;
        }
        vis[sr][sc] = true;
        int count = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c]){
                count += floodFill(r, c, er, ec, dir, vis, dirS, psf + dirS[d] + "");
            }
        }

        vis[sr][sc] = false;
        return count;
    }
    public static class pathPair{
        int len = 0;
        String psf = "";
        int count = 0;
        pathPair(int len, String psf, int count){
            this.len = len;
            this.psf = psf;
            this.count = count;
        }
    }

    public static pathPair floodFill_LongestPath(int sr, int sc, int er, int ec, int[][] dir, boolean[][] vis, String[] Sdir){
        if(sr == er && sc == ec){
            return new pathPair(0,"",1);
        }
        vis[sr][sc] = true;
        pathPair myAns = new pathPair(0,"",0);
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c]){
                pathPair recAns = floodFill_LongestPath(r, c, er, ec, dir, vis, Sdir);
                if(recAns.len + 1 > myAns.len){
                    myAns.len = recAns.len + 1;
                    myAns.psf = Sdir[d] + recAns.psf;
                }
                myAns.count += recAns.count;
            }
        }
        vis[sr][sc] = false;
        return myAns;
    }

    public static pathPair floodFill_shortestPath(int sr, int sc, int er, int ec, int[][] dir, boolean[][] vis, String[] Sdir){
        if(sr == er && sc == ec){
            return new pathPair(0,"",1);
        }
        vis[sr][sc] = true;
        pathPair myAns = new pathPair((int)1e8,"",0);
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c]){
                pathPair recAns = floodFill_shortestPath(r, c, er, ec, dir, vis, Sdir);
                if(recAns.len + 1 < myAns.len){
                    myAns.len = recAns.len + 1;
                    myAns.psf = Sdir[d] + recAns.psf;
                }
                myAns.count += recAns.count;
            }
        }
        vis[sr][sc] = false;
        return myAns;
    }

    public static void main(String[] args){
        int n = 4, m = 4;
        int[][] dir ={{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
        String[] Sdir = {"d", "w", "l", "n", "u", "e", "r", "s"};
        boolean[][] vis = new boolean[n][m];
        // int ans = floodFill(0, 0, n - 1, m - 1, dir, vis, Sdir,"");
        // System.out.println(ans);
        pathPair ans = floodFill_LongestPath(0, 0, n - 1, m - 1, dir, vis, Sdir);
        System.out.println("path: " + ans.psf + "\n" + "len: " + ans.len + "\n" + "count: " + ans.count);
        pathPair ans2 = floodFill_shortestPath(0, 0, n - 1, m - 1, dir, vis, Sdir);
        System.out.println("path: " + ans2.psf + "\n" + "len: " + ans2.len + "\n" + "count: " + ans2.count);
        
    }
}