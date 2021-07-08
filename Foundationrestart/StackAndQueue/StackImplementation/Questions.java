public class Questions{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int[] a = new int
    }
  public static int[] NGOR(int[] arr){
        int n = arr.length;
        LinkedList< Integer > st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = 0 ; i < n ; i++){
            while(st.size() != 0 && arr[st.getFirst()] < arr[i]){
                ans[st.getFirst()] = arr[i];
                st.removeFirst();
           }
           st.addFirst(i);
        }
        return ans;
 }
  public static int[] NGOL(int[] arr){
        int n = arr.length;
        LinkedList< Integer > st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = n ; i >= 0 ; i++){
            while(st.size() != 0 && arr[st.getFirst()] < arr[i]){
                ans[st.getFirst()] = arr[i];
                st.removeFirst();
           }
           st.addFirst(i);
        }
        return ans;
 }
 public static int[] NSOL(int[] arr){
        LinkedList<Integer> st = new LinkedList<>();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        
        for(int i = n - 1; i >= 0; i--){
            while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }
            st.addFirst(i);
        }
        return ans;
    }
    
    public static int[] NSOR(int[] arr){
        LinkedList<Integer> st = new LinkedList<>();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,n);
        
        for(int i = 0; i < n; i++){
            while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }
            st.addFirst(i);
        }
        return ans;
    }
    
    public static void largestArea(int[] arr){
        int[] nsol = NSOL(arr);
        int[] nsor = NSOR(arr);
        
        int n = arr.length;
        int area = 0;
        for(int i=0;i<n;i++){
            area = Math.max(area,(nsor[i] - nsol[i] - 1) * arr[i]);
        }
        
        System.out.println(area);
    }
}