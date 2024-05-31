 public void DFS(int V, ArrayList<ArrayList<Integer>> adj,int curr,boolean[] vis,ArrayList<Integer>ans){
         vis[curr]=true;
         ans.add(curr);
         for(int i=0;i<adj.get(curr).size();i++){
             if(vis[adj.get(curr).get(i)]==false){
                 DFS(V,adj,adj.get(curr).get(i),vis,ans);
             }
         }
     }
