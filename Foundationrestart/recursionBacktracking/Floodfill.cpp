#include<iostream>
#include<vector>

using namespace std;

int floodFill(int sr,int sc,int er,int ec,vector<vector<int>> &dir,vector<string> &dirS,vector<vector<bool>> &vis,string ans){
    if(sr == er && sc == ec){
        cout<<ans<<endl;
        return 1;
    }

    vis[sr][sc] = true;
    
    int n = vis.size();
    int m = vis[0].size();

    int count = 0;

    for(int d = 0;d < dir.size();d++){
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];

        //check r an c in boundary and infinite loop condition.
        if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]){
            count  += floodFill(r,c,er,ec,dir,dirS,vis,ans + dirS[d]);
        }
    }
    vis[sr][sc] = false;
    return count;
}

int floodFillJump(int sr,int sc,int er,int ec,vector<vector<int>> &dir,vector<string> &dirS,vector<vector<bool>> &vis,string ans){
    if(sr == er && sc == ec){
        cout<<ans<<endl;
        return 1;
    }

    vis[sr][sc] = true;
    
    int n = vis.size();
    int m = vis[0].size();

    int count = 0;

for(int rad = 1;rad <= max(n,m);rad++){
    for(int d = 0;d < dir.size();d++){
        int r = sr + rad * dir[d][0];
        int c = sc + rad * dir[d][1];

        //check r an c in boundary and infinite loop condition.
        if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]){
            count  += floodFillJump(r,c,er,ec,dir,dirS,vis,ans + dirS[d] + string(1,rad));
        }
    }
}
    vis[sr][sc] = false;
    return count;
}

int main(){
    vector<vector<int>> dir = {{0,-1},{1,0},{0,1},{-1,0}};
    vector<string> dirS = {"L","D","R","U"};
    int n = 3;
    int m = 3;
    vector<vector<bool>> vis(n,vector<bool> (m,0));
    cout<<floodFillJump(0,0,n-1,m-1,dir,dirS,vis,"");
    return 0;
}