public class gccPortal{
      public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int src, ArrayList<Integer> comp ){
       vis[src] = true;
       comp.add(src);
       for(Edge e : graph[src]){
           if(!vis[e.nbr]){
               dfs(graph,vis,e.nbr,comp);
           }
       }
   }

   public static void gcc(){
       boolean[] vis = new boolean[vtces];
      for(int i = 0; i < vtces; i++){
          if(!vis[i]){
              ArrayList<Integer> comp = new ArrayList<>();
              dfs(graph,vis,i,comp);
              comps.add(comp);
          }
      }

      System.out.println(comps);
   }
}