#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
bool arrayPalindrome(vector<int>& arr ,int vsi,int vli)
{
    if(vsi >= vli)return true;
    if(arr[vsi] != arr[vli]) return false;
     return arrayPalindrome(arr,vsi+1,vli-1);
}

int main() {
    int n;cin>>n;
    vector<int> ar(n,0);
    for(int i=0;i<n;i++)
    {
        cin>>ar[i];
    }
    cout<<(boolalpha) <<arrayPalindrome(ar,0,n-1);
        return 0;
}
