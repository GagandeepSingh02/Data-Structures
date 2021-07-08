void printtriangle(int row)
{
    int nst=1;   //no of stars
    for(int r=1;r<=row;r++)
      {
          for(int cst=1;cst<=nst;cst++)
          {
              cout<<"*\t";
          }
          cout<<endl;
          nst++;
      }
}
void printReversetriangle(int row)
{
    int nst=row;   //no of stars
    for(int r=1;r<=row;r++)
      {
          for(int cst=nst;cst>=1;cst--)
          {
              cout<<"*\t";
          }
          cout<<endl;
          nst--;
      }
}
void printMirrortriangle2(int row)
{
    int nst=row;   //no of stars
    int nsp=0;
    for(int r=1;r<=row;r++)
      {
          for(int csp=1;csp<=nsp;csp++)
          {
              cout<<"\t";
          }
          for(int cst=nst;cst>=1;cst--)
          {
              cout<<"*\t";
          }
          cout<<endl;
          nst--;
          nsp++;
      }
}
void Pattern7(int row)
{
    int nsp=1;
    for(int r=1;r<=row;r++)
    {
        for(int csp=1;csp<nsp;csp++)
        {
            cout<<"\t";
        }
        cout<<"*\t"<<endl;
        nsp++;
        
    }

}

void Pattern10(int row)
{
    int nsp1=row/2;
    int nsp2=-1;
    for(int r=1;r<=row;r++){
        for(int csp=1;csp<=nsp1;csp++)
        {
            cout<<"\t";
        }
        cout<<"*\t";
        for(int csp=1;csp<=nsp2;csp++)
        {
            cout<<"\t";
        }
        if(r==1 || r==row)
        {
        cout<<endl;
        }else{
              cout<<"*\t"<<endl;
        }
        if(r<=row/2)
        {
            nsp2+=2;
            nsp1--;
        }
        else{
            nsp2-=2;
            nsp1++;
        }
    }
}
void pattern12(int row)
{
    int nst=1;
    int a=0,b=1;
     int count=0;
    for(int r=1;r<=row;r++)
    {
        for(int cst=1;cst<=nst;cst++)
        {
            cout<<a<<"\t";
            count=a+b;
            a=b;
            b=count;
        }
        cout<<endl;
        nst++;
    }
}

void pattern16(int row)
{    
   
    int nst=1;
    int nsp=2*row-3;
    for(int r=1;r<=row;r++)
    {
         int count=1;
        for(int cst=1;cst<=nst;cst++)
        {
            cout<<count<<"\t";
            count++;
        }
        for(int csp=1;csp<=nsp;csp++)
        {
            cout<<"\t";
        }
        count--;
        int cst=1;
        if(r==row)
        {
        count--;
        cst=2;
        }
        while(cst<=nst)
        {
          cout<<count<<"\t";
          cst++;
          count--;
        }
        nsp-=2;
        nst++;
        cout<<endl;
    }
}

void pattern14(int x)
{
    for(int i=1;i<=10;i++)
    {
        cout<<x<<" * "<<i<<" = "<< x*i<<endl;
    }
}

void pattern17(int row)
    {
        int nsp=row/2,nst=1,mnst=row;
        for(int r=1;r<=row;r++)
        {   
            if(r!=row/2+1)
            {
            for(int csp=0;csp<nsp;csp++)
            {
                cout<<"\t";
            }
            
            for(int cst=1;cst<=nst;cst++)
            {
                 cout<<"*\t";
            }
            }
            else{
                for(int cst=1;cst<=mnst;cst++)
                {
                    cout<<"*\t";
                }
            }
            if(r<=row/2)
            {
                nst++;
            }
            else{
                nst--;
            }
            cout<<endl;
        }
    }