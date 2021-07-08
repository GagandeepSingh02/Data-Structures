void WavePrint(vector<vector<int>>& a)
{
    int n=a.size();
    int m=a[0].size();
    for(int j=0;j<m; j++)
    {
        if(j%2==0)
        {
        for(int i=0; i<n; i++)
        {
            cout<<a[i][j]<<endl;
        }
        }
        else{
            for(int i=n-1; i>=0; i--)
            {
                cout<<a[i][j]<<endl;
            }
        }
    }
}