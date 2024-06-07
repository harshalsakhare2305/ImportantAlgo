class Solution
{    int time=0;
    public void DFS(int V,ArrayList<ArrayList<Integer>> adj,int curr,int parent,
    int[]vis, int[]tin ,int[]tlow,int[]mark){
        vis[curr]=1;
        tin[curr]=time;
        tlow[curr]=time;
        time++;
        int child=0;
        
        for(int it:adj.get(curr)){
            if(it==parent) continue;
            if(vis[it]==0){
                 DFS(V,adj,it,curr,vis,tin,tlow,mark);
                 tlow[curr]=Math.min(tlow[it],tlow[curr]);
                 if(tlow[it]>=tin[curr] && parent!=-1){
                     mark[curr]=1;

                 }
                 child++;
            }else{
                tlow[curr]=Math.min(tlow[curr],tin[it]);
            }
            
           
        }
        
        if(child>1 && parent==-1){
            mark[curr]=1;
        }
    }
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        //  ArrayList<ArrayList<Integer>> adjN =new ArrayList<>();
        //  for(int i=0;i<V;i++){
        //      adjN.add(new ArrayList<Integer>());
        //  }
         
        //  for(int i=0;i<V;i++){
        //      for(int it:adj.get(i)){
        //          int u=i;
        //          int v =it;
                 
        //          adjN.get(u).add(v);
        //          adjN.get(v).add(u);
        //      }
        //  }
        int[] vis= new int[V];
        int[] tin =new int[V];
        int[] tlow= new int[V];
        int[] mark =new int[V];
        Arrays.fill(mark,0);
        
        DFS(V,adj,0,-1,vis,tin,tlow,mark);
        
        ArrayList<Integer> ans =new ArrayList<>();
        for(int i=0;i<V;i++){
            if(mark[i]==1){
                ans.add(i);
            }
        }
        if(ans.size()==0){
              ans.add(-1);
        }
        
       Collections.sort(ans);
       
       return ans;
    }
}
