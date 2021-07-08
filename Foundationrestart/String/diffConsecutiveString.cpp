#include<iostream>
using namespace std;
string diff(string str)
{
    if(str.length()<=0) return str;
    string ans="";
    ans+=str[0];
    for(int i=1;i<str.length();i++)
    {
        char ch0=str[i-1];
        char ch1=str[i];
        ans+=to_string(ch1-ch0);
        ans+=ch1;
    }
    return ans;
}

int main()
{
    string str;
    cin>>str;
    cout<<diff(str);
}