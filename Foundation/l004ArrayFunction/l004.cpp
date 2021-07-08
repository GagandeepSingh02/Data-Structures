include<iostream>
using namespace std;
int binary search(vector<int>& a,int data)
{
    int si=0,li=a.length;
    while(si<=li)
    {
        int mid=(si+li)/2;
        if(a[mid]<data)
        {
            si=mid;
        }
        else if(a[mid]<data)
        {
            li=mid;
        }
        else{
            return mid
        }

    }
    return -1;
}

//==========================================================================


int max(vector<int>& arr)
{
   int max= (int)-1e8; 
   for(int i=0;i<arr.size();i++)
   {
       if(arr[i]>max) max=arr[i];
   }
   return max;
}
//===========================================================================
void BarChart(vector<int>& a)
{
     int maximum= max(a);
    for(int flor=maximum; flor>=1;flor--)
    {
        for(int i=0;i<a.size();i++)
        {
            if(a[i]>=flor)
            {
                cout<<"*\t";
            }else{
                cout<<"\t";
            }
        }
        cout<<endl;
    }
    
}
int main()
{
    int n, data;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<arr.size();i++)
    {
        cin>>arr[i];
    }
    cin>>data;
   cout<< findEle(arr , data);
   cout<< firstIndex(arr , data);
   cout<< LastIndex(arr , data);
}
