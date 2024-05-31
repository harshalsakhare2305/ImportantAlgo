public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
         Queue<Integer> q =new LinkedList<>();
         q.add(0);
         ArrayList<Integer> ans =new ArrayList<>();
         boolean[] vis =new boolean[V];
         while(!q.isEmpty()){
             int curr =q.poll();
             if(vis[curr]==false){
                 ans.add(curr);
                 vis[curr]=true;
                 for(int i=0;i<adj.get(curr).size();i++){
                     q.add(adj.get(curr).get(i));
                 }
             }
         }
         
         return ans;
    }
