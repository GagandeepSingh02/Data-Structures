#include<iostream>
#include<vector>

using namespace std;

int equiSet(vector<int> &arr,int idx,int sum1,int sum2,string set1,string set2){
    if(idx == arr.size())
    {
        if(sum1 == sum2){
            cout<<set1+"="+set2<<endl;
            return 1;
        }
    return 0;
    }

    int count  = 0;

    count += equiSet(arr,idx + 1,sum1 + arr[idx],sum2,set1 + to_string(arr[idx]) + " ",set2);
    count += equiSet(arr,idx + 1,sum1,sum2 + arr[idx],set1,set2 + to_string(arr[idx]) + " ");

    return count;
}

int main(){
    vector<int> arr = {10,20,30,40,50,60,70,80};
    cout<<equiSet(arr,1,arr[0],0,to_string(arr[0]) + " "," "); 
    return 0;
}