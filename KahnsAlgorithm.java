 static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
      int[] indeg =new int[V];
      for(int i=0;i<V;i++){
          for(int j=0;j<adj.get(i).size();j++){
              int dest =adj.get(i).get(j);
              indeg[dest]++;
          }
      }
      
      Queue<Integer> q =new LinkedList<>();
      for(int i=0;i<V;i++){
          if(indeg[i]==0){
              q.add(i);
          }
      }
      
      int j=0;
      int[] ans =new int[V];
      while(!q.isEmpty()){
          int curr =q.poll();
          ans[j++]=curr;
          for(int i=0;i<adj.get(curr).size();i++){
              int dest =adj.get(curr).get(i);
              indeg[dest]--;
              if(indeg[dest]==0){
                  q.add(dest);
              }
          }
      }
      return ans;
    }
