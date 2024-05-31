 class Solution {
   
   public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj,int curr,int parent,boolean[] vis){
       vis[curr]=true;
       for(int i=0;i<adj.get(curr).size();i++){
           int dest =adj.get(curr).get(i);
           if(vis[dest]==true && parent!=dest){
               return true;
           }else if(vis[dest]==false){
               if(isCycle(V,adj,dest,curr,vis)) return true;
           }
       }
       
       return false;
   }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean[] vis =new boolean[V];
         for(int i=0;i<V;i++){
             if(vis[i]==false){
                if(isCycle(V,adj,i,-1,vis)){
                    return true;
                }
                
             }
         }
         
         return false;
    }
}
