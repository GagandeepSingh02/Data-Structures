#include<iostream>
#include<vector>
using namespace std;
void input(vector<vector<int>>& arr){
        int n=arr.size();
        int m=arr[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cin>>arr[i][j];
            }
        }
    }
void display(vector<vector<int>>& arr){
        int n=arr.size();
        int m=arr[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cout<<arr[i][j] <<" ";
            }
            cout<<endl;
        }
    }

int main(){
        int n,m;
        cin>>n>>m;
        vector<vector<int>>arr(n,vector<int>(m,0));
        input(arr);
        display(arr);
        return 0;
    }
   
