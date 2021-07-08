#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
void swap(vector<int>& arr , int si,int ei)
{
    int temp=arr[si];
    arr[si]=arr[ei];
    arr[ei]=temp;    
}
void arrayReverse(vector<int>& arr,int si,int ei)
{
    if(si>=ei) return;
    swap(arr,si,ei);
    arrayReverse(arr,si+1,ei-1);
}

int main() {
   int n;
    cin>>n;
    vector<int> ar(n,0);
    for(int i=0;i<n;i++)
    {
        cin>>ar[i];        
    }
    int idx; cin>>idx;
    arrayReverse(ar,0,n-1);
    for(int i=0;i<n;i++) cout<<ar[i]<<" ";
    cout<<endl;
    cout<<ar[idx];
    
    return 0;
}
