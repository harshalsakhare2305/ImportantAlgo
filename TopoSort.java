class Solution
{
    static void DFS(int V, ArrayList<ArrayList<Integer>> adj,int start,int[] vis,Stack<Integer>st){
        vis[start]=1;
        for(int i=0;i<adj.get(start).size();i++){
            int dest =adj.get(start).get(i);
            if(vis[dest]==0){
                DFS(V,adj,dest,vis,st);
            }
        }
        
        st.push(start);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       int[] vis =new int[V];
       Stack<Integer> st  =new Stack<>();
       for(int i=0;i<V;i++){
           if(vis[i]==0){
               DFS(V,adj,i,vis,st);
           }
       }
       
       int[] ans =new int[V];
       int i=0;
       while(!st.isEmpty()){
           ans[i++]=st.pop();
       }
       
       return ans;
    }
}
