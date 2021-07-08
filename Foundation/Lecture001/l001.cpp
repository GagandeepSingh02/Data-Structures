#include<iostream>
using namespace std;

void printFibbo(int n){
    int a=0,b=1,sum=0;
    for(int i=1;i<=n;i++)
    {
        cout<<a<<endl;
        sum=a+b;
        a=b;
        b=a;
    }
}
int countDigit(int n)
   {
       int count=0;
       int num=n;
       while(num>0)
       {
           num=num/10;
           count++;
       }
       return count;
   }

int rotateNumber(int n , int r)
{
    int len=countDigit(n);
    r%=len;
    if(r<0) r=(r+len)%len;
    int mul=1,div=1;
    for(int i=1;i<=len;i++)
    {
       if(i<=r)div=div*10;
       else mul=mul*10;
    }
    int a= n%div;
    int b=n/div;

    return b*mul+a;
}
int gcd(int a , int b)
{

}
void gradingSystem(int n){
    if(n>90){
        cout<<"excellent"<<endl;
    }else if(n> 80 && n<=90){
        cout<<"good"<<endl;
    }else if(n>70 && n<=80){
         cout<<"fair"<<endl;
    }else if(n>60 && n<=70){
        cout<<"meets expectations"<<endl;
    }else{
        cout<<"below par"<<endl;
    }
    
}
void printz(){
    
    cout<<"*****"<<endl;
    cout<<"   *"<<endl;
    cout<<"  *"<<endl;
    cout<<" *"<<endl;
    cout<<"*****"<<endl;
}
bool isprime_(int n) 
int main(){
    int marks;
    cin>>marks;
    printz();
    gradingSystem(marks);
    return 0;
}




