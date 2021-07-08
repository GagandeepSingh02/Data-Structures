#include<iostream>
#include<vector>
using namespace std;

int findEle(vector<int>& arr , int data)
{
    int idx=-1;
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]==data)
        {
            idx=i;
            break;
        }
    }
    return idx;
}

//=================================================================


int firstIndex(vector<int>& arr , int data)
{
    int idx=-1;
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]==data)
        {
            idx=i;
            break;
        }
    }
    return idx;
}

//=================================================================================


int LastIndex(vector<int>& arr , int data)
{
    int idx=-1;
    for(int i=arr.size()-1;i>=0;i--)
    {
        if(arr[i]==data)
        {
            idx=i;
            break;
        }
    }
    return idx;
}

//============================================================================


void SumArray(vector<int>& arr1, vector<int>& arr2, int n1, int n2)
{    
    int c=0;
    vector<int> sum(n1>n2 ? n1:n2);
    int k=sum.size()-1;
    int i=arr1.size()-1;
    int j=arr2.size()-1;
    while(k>=0)
    {
        int d=c;
        if(i>=0)
        {
            d+=arr1[i];
        }
        if(j>=0)
        {
            d+=arr2[j];
        }
        c=d/10;
        d=d%10;
        sum[k]=d;
        k--;
        i--;
        j--;
    }
    if(c !=0)
    {
        cout<<c<<endl;
    }
    for(int val:sum)
    {
        cout<<val<<endl;
    }
}

//=======================================================================


void reverse(vector<int>& a)
{
    int li=0;
    int ri=a.size()-1;
    while(li < ri)
    {
        int swap=a[ri];
        a[ri]=a[li];
        a[li]=swap;
        li++;
        ri--;
    }
    for(int val:a)
    {
        cout<<val<<" ";
    }
}

//=============================================================

void CielFloor(vector<int>& a , int d)
{
    int ciel=0,flor=0;
    for(int i=0;i<a.size();i++)
    {
        if(a[i]>d)
        {
            ciel=a[i];
            break;
        }else if(a[i]==d){
            ciel=a[i];
            break;
        }
        if(a[i]< d)
        {
            flor=a[i];
        }
    }
    cout<<ciel<<endl;
     cout<<flor<<endl;
}
//====================================================================

void SubArray(vector<int>& arr , int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=i;j<n;j++)
        {
            for(int k=i;k<=j;k++)
            {
                cout<<arr[k]<<"\t";
            }
            cout<<endl;
        }
    }                                                      n
}

