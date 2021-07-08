#include <iostream>
using namespace std;

int subtract(int a,int b)
{
    int c = b - a;
    return c;
}

int divide(int a,int b)
{
    int c = b / a;
    return c;
}

int multiply(int a,int b)
{
    int c = a * b;
    return c;
}

int add(int a,int b)
{
    int c = a + b;
    return c;
}
void printmessage(){
   cout << "see you soon!"<<endl; 
}

//==============================================================================================

void printTableOfN(int n)
{
    for(int i=1;i<=10;i++)
    {
        cout<<to_string(n) +" X "+ to_string(i)+" = " + to_string(n*i)<< endl;
    }
}

//==============================================================================================
void printTableTillM(int m)
{
    for(int i=1;i<=m;i++)
    {
        printTableOfN(i);
        cout<<endl;
    }
}

//===========================================================================================

void oddeven(int n)
{
        if(n % 2 == 0)
            cout<<"even"<< endl;
        else{
            cout<<"odd"<< endl;
        }
}

//==================================================================================================

int main()
{
    int n,m;
    cin>>n;
    // int a, b;
    // cin >> a >> b;
    // cout << multiply(a,b) << endl;
    // cout << multiply(a,b) << endl;
    // cout << multiply(a,b) << endl;
    // cout << multiply(a,b) << endl;
    // cout << multiply(a,b) << endl;
    // cout << add(a,b) << endl;
    // printmessage();
    //printTableTillM(m);
    for(int i=0;i<n;i++)
    {
        cin>>m;
        oddeven(m);
    }
    return 0;
}