public class practice{
    public static void print(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    public static void print2D(int[][] arr) {
        for (int[] a : arr) {
            print(a);
        }

        System.out.println();
    }

    public static int diceThrow(int n,int[]dp){
        if(n == 0){
            return dp[n] = 1;
        }
        if(dp[n] != 0) return dp[n];
        int count = 0;
        for(int dice = 1; dice <= 6 && n - dice >= 0; dice++){
            count += diceThrow(n - dice, dp);
        }
        return dp[n] = count;
    }

    public static int diceThrow_DP(int N,int[]dp){
        for(int n = 0; n <= N; n++){
        if(n == 0){
            dp[n] = 1;
            continue;
        }
        int count = 0;
        for(int dice = 1; dice <= 6 && n - dice >= 0; dice++){
            count += dp[n - dice];
        }
        dp[n] = count;
        }
        return dp[N];
    }

    public static int diceThrow_Opti(int n){
        LinkedList ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(1);
        for(int i = 2; i <= N; i++){
            if(i <= 6){
                
            }
        }
    }

    public static void main(String[] args){
        int n = 10;
        int[] dp = new int[n + 1];
        int ans = diceThrow_DP(n,dp);
        System.out.println(ans);
        print(dp);
    }
}