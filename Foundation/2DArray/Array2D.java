public static void main(String[] args) throws Exception {
    // write your code here
    int n=scn.nextInt();
    int m=scn.nextInt();
    int[][] a= new int[n][m];
    input( a );
    waveprint(a,n,m);
 }

//=========================================================================


 public static void input(int[][] a)
 {
     for(int i=0;i<a.length;i++)
     {
         for(int j=0;j<a[i].length;j++)
         {
             a[i][j]=scn.nextInt();
         }
     }
 }
 
//============================================================================


public static void waveprint(int[][] arr , int row,int col)
 {
     for(int j=0;j<col;j++)
     {
         if(j % 2 == 0)
         {
         for(int i=0;i<row;i++)
         {
             System.out.println(arr[i][j]);
         }
         }
         else{
             for(int i=row-1;i>=0;i--)
         {
             System.out.println(arr[i][j]);
         }
         }
     }
 }

//==========================================================================


public static void output(int[][] a)
{
    for(int i=0;i<a.length;i++)
     {
         for(int j=0;j<a[i].length;j++)
         {
             System.out.print(a[i][j] + " ");
         }
         System.out.println();
     }
}

//========================================================================


public static void endpoint(int[][] arr ,int row , int col)
{
    int i=0,j=0,d=0;
    while(true)
    {
        d=(d+arr[i][j] ) % 4;

        if(d==0){            //East
            j++;
            if(j==col){
                 System.out.println(i);
                System.out.println(j-1);
                break;
            }
        }else if(d==1){          //south
            i++;
            if(i==row){
                System.out.println(i-1);
                 System.out.println(j);
                 break;
            }
        }else if(d==2){               //west
            j--;
            if(j==-1){
                 System.out.println(i);
                System.out.println(j+1);
                break;
            }
        }else if(d==3){                 //North
            i--;
            if(i==-1){
                 System.out.println(i+1);
                  System.out.println(j);
                  break;
            }
        }
    }
}
//===========================================================

public static void DiagonalPrint(int[][] a)
{
    for(int gap=0;gap<a[0].length;gap++)
    {
        for(int i=0,j=gap;i<a.length&&j<a[0].length;i++,j++)
        {
            System.out.println(a[i][j]);
        }
    }
}

//==============================================================

public static void SaddlePoint(int[][] a)
{
    int SaddlePoint=(int)-1e8;
    for(int i=0;i<a.length;i++)              //My method Sir's method in notebook
    {      int k=0;                          // Same complexity
        for(int j=0; j<a[0].length;j++)
        {
            if(a[i][j] > a[k][0] && a[i][j]>a[0][k])
            {
                SaddlePoint=(a[i][j]);
                break;
            }
            k++;
        }
    }
    if(SaddlePoint<0)
    {
        System.out.println("Invalid input");
    }else{
    System.out.println(SaddlePoint);
    }  
}

//======================================================================

public static void rotate90Degree(int[][] a)
{
    //pehle transpose
    int n=a.length;

    for(int i=0;i<n;i++)
    {
        for(int j=i;j<n;j++){
        int temp=a[i][j];
        a[i][j]=a[j][i];
        a[j][i]=temp;
        }
    }
    int c1=0,c2=n-1;
    while(c1<c2)
    {
        for(int r=0;r<n;r++)
        {
            int e1=a[r][c1];
            int e2=a[r][c2];
            
            a[r][c1]=e2;
            a[r][c2]=e1;
        }
        c1++;
        c2--;
    }
}

public static void SpiralDisplay(int[][] arr){
        
        int n = arr.length, m = arr[0].length, count = n * m;
        int rmin = 0, rmax = n - 1;
        int cmin = 0, cmax = m - 1;
         
        while(count != 0){

            for(int r = rmin; r <= rmax && count > 0; r++){
                System.out.println(arr[r][cmin]);
                count--;
            }
            cmin++;

            
            for(int c = cmin; c <= cmax && count > 0; c++){
                System.out.println(arr[rmax][c]);
                count--;
            }
            rmax--;

            for(int r = rmax; r >= rmin && count > 0; r--){
                System.out.println(arr[r][cmax]);
                count--;
            }
            cmax--;

            for(int c = cmax; c >= cmin && count > 0; c--){
                System.out.println(arr[rmin][c]);
                count--;
            }
            rmin++;
        }

}

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
