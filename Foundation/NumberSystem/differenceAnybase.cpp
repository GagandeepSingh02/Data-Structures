#include<iostream>
using namespace std;
int differenceAnybase(int n1,int n2,int b)
{
    int res=0,multip=1,diff=0,r1=0,r2=0,borrow=0;
    while(n1>0 || n2>0)
    {
        r1=n1%10;
        r2=n2%10;
        n1/=10;
        n2/=10;
        diff=r2-r1+borrow;
        if(diff<0)
        {
            diff+=b;
            borrow=-1;
        }
        else{
            borrow=0;
        }
        res+=diff*multip;
        multip*=10;
    }
    return res;
}
int main()
{
    int n1,n2,b;
    cin>>b>>n1>>n2;
   cout<<differenceAnybase(n1,n2,b);
}