#include<iostream>
using namespace std;
 int Tribonacci(int n){
     if(n<=2) return n == 2 ? 1:n;
     return Tribonacci(n-1)+ Tribonacci(n-2)+ Tribonacci(n-3);

 }
 int main()
 {
     int n;
     cin>>n;
     cout<< Tribonacci(n)<< endl;
     return 0;
 }