bool isprime(int n)
{
    for(int i=2;i*i<=n;i++)
    {
    if(n % i == 0) return false;
    }
    return true;
}
void checkPrime(int t)
{
    for(int i=0;i<t;i++)
    { 
        int n;  cin>>n;
        if(isprime(n)) cout<<"prime"<<endl;
        else cout<<"not prime"<<endl;
    }

}
//===================================================================================================

bool isPrime(int n){
    
    for(int i=2;i*i<=n ;i++)
    {
    if(n % i == 0) return false; 
    }
    return true;
    
}
void primesTillN(int L , int H)
{
    
   for(int i=L;i<=H;i++)
   {
       
       if( isPrime(i) ) cout<<i<<endl;
       
   }
   
}
//====================================================================================================

void Fibonacci(int n)
{
    int a=0,b=1,sum=0;
    for(int i=0;i<n;i++)
    {
        cout<<a<<endl;
        sum=a+b;
        a=b;
        b=sum;
    }
}

//====================================================================================================

int countDigit(int n)
{
    int num=n,count=0;
    while(num != 0)
    {
        num=num/10;
        count++;
    }
    return count;
}
//=======================================================================================================

int main(int argc, char **argv){
    int t;
    cin >> t;
    checkPrime(t);
    //write your code here
    
}