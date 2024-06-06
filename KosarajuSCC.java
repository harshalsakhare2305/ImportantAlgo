class Solution
{
     public void DFS(int V, ArrayList<ArrayList<Integer>> adj,int curr,int[] vis,Stack<Integer>st){
         vis[curr]=1;
        
         for(int i=0;i<adj.get(curr).size();i++){
             if(vis[adj.get(curr).get(i)]==0){
                 DFS(V,adj,adj.get(curr).get(i),vis,st);
             }
         }
         
         st.push(curr);
     }
     
      public void DFS(int V,ArrayList<ArrayList<Integer>> adj,int curr,boolean[] vis){
         vis[curr]=true;
        
         for(int i=0;i<adj.get(curr).size();i++){
             if(vis[adj.get(curr).get(i)]==false){
                 DFS(V,adj,adj.get(curr).get(i),vis);
             }
         }
     }
  
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
          int[] vis =new int[V];
          Stack<Integer> st =new Stack<>();
          for(int i=0;i<V;i++){
              if(vis[i]==0){
                  DFS(V,adj,i,vis,st);
              }
          }
          
          
          //revese the graph 
          ArrayList<ArrayList<Integer>> adjT =new ArrayList<>();
          for(int i=0;i<V;i++){
               adjT.add(new ArrayList<Integer>());
          }
          
          
          for(int i=0;i<V;i++){
              for(int it:adj.get(i)){
                  adjT.get(it).add(i);
              }
          }
          boolean[] visT=new boolean[V];
          int scc=0;
          
          while(!st.isEmpty()){
              int curr =st.pop();
              if(!visT[curr]){
                  scc++;
                  DFS(V,adjT,curr,visT);
              }
              
          }
          
          return scc;
    }
}
