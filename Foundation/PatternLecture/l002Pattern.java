 public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        printtriangle(n);

    }
   public static void printtriangle(int row)
{
    int nst=1;   //no of stars
    for(int r=1;r<=row;r++)
      {
          for(int cst=1;cst<=nst;cst++)
          {
              System.out.print("*\t");
          }
           System.out.println();
          nst++;
      }
}
  public static void printReversetriangle(int row)
{
    int nst=row;   //no of stars
    for(int r=1;r<=row;r++)
      {
          for(int cst=nst;cst>=1;cst--)
          {
              System.out.print("*\t");
          }
           System.out.println();
          nst--;
      }
}
 public static void printMirrortriangle(int row)
{
    int nst=1;   //no of stars
    int nsp=row-1;
    for(int r=1;r<=row;r++)
      {
          for(int csp=1;csp<=nsp;csp++)
          {
              System.out.print("\t");
          }
          for(int cst=1;cst<=nst;cst++)
          {
              System.out.print("*\t");
          }
           System.out.println();
          nst++;
          nsp--;
      }
}

public static void Pattern5(int row)
{
    int nst=1;
    int nsp=row/2;
    for(int r=1;r<=row;r++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }
        if(r<=row/2)
        {
            nst+=2;
            nsp--;
        }
        else{
            nst-=2;
            nsp++;
        }
        System.out.println();
    }
}
public static void Pattern6(int row)
{
    int nst=row/2+1;
    int nsp=1;
    for(int r=1;r<=row;r++)
    {
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }
        if(r<=row/2)
        {
            nst--;
            nsp+=2;
        }
        else{
            nst++;
            nsp-=2;;
        }
        System.out.println();
    }
}

   public static void Pattern15(int row)
{   
    int count=1;
    int nst=1;
    int nsp=row/2;
    for(int r=1;r<=row;r++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
        //int count =r;               Yeh condition sirr ne krayi same work kregi as 
        //if(r>(row/2))
        //count=row-r+1;                            //my last line of count
       
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print(number+"\t");
            if(cst<=nst/2)
            {
                count++;
            }
            else
            {
                count--;
            }
        }
              
        if(r<=row/2)
        {   
            nst+=2;
            nsp--;
        }
        else{
            nst-=2;
            nsp++;
        }
        count=(row/2)- nsp +1;
        System.out.println();
    }
}
public static void pattern8(int row)
{
    int nsp=row-1;
      for(int r=1;r<=row;r++)
      {
          for(int csp=1;csp<=nsp;csp++)
          {
              System.out.print("\t");
          }
          System.out.println("*\t");
          nsp--;
      }

}
public static void Pattern9(int row)
{
    int nsp1=0;
    int nsp2=row/2+1;
    for(int r=1;r<=row;r++)
    {
        for(int csp=1;csp<=nsp1;csp++)
        {
            System.out.print("\t");
        }
        System.out.print("*\t");
        for(int csp=1;csp<=nsp2;csp++)
        {
            System.out.print("\t");
        }
        System.out.println("*\t");

        if(r<row/2)
        {
            nsp1++;
            nsp-=2;
        }
        else{
            nsp1--;
            nsp2+=2;
        }
    }
}

 public static void Pattern11(int row){
    int nst=1; 
    int count=1;
    for(int r=1;r<=row;r++)
    {
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print(count+"\t");
            count++;
        }
        System.out.println();
        nst++;
    }
}
    public static void pattern13(int row){
    for(int n=0;n<row;n++)
    {    
        int val=1;
        for(int r=0;r<=n;r++)
        {
            System.out.print(val+"\t");
            val=((n-r)*val)/(r+1);
        }
        System.out.println();
    }
}
public static void pattern17(int row)
    {
        int nsp=row/2,nst=1,mnst=row;
        for(int r=1;r<=row;r++)
        {   
            if(r!=row/2+1)
            {
            for(int csp=0;csp<nsp;csp++)
            {
                System.out.print("\t");
            }
            
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print("*\t");
            }
            }
            else{
                for(int cst=1;cst<=mnst;cst++)
                {
                    System.out.print("*\t");
                }
            }
            if(r<=row/2)
            {
                nst++;
            }
            else{
                nst--;
            }
            System.out.println();
        }
    }
}