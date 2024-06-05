class DisJointSet{
        int[] size;
        int[]parent ;
    
        public DisJointSet(int n){
            size =new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++){
                size[i]=1;
                parent[i]=i;
            }
        }
    
        int findparent(int u){
            if(u==parent[u]){
                return u;
            }
            
            return parent[u]=findparent(parent[u]);
        }
    
        void union(int u,int v){
            int ulp_u =findparent(u);
            int ulp_v=findparent(v);
            if(ulp_u==ulp_v) return;
            if(size[ulp_u] < size[ulp_v]){
                parent[ulp_u]=ulp_v;
                size[ulp_v]+=size[ulp_u];
            }else{
                parent[ulp_v]=ulp_u;
                size[ulp_u]+=size[ulp_v];
            }
    }
    }
   
    

 class Solution {
    static int KruskalAlgo(int V, int E, List<List<int[]>> adj) {
          
          List<int[]> edges =new ArrayList<>();
          for(int i=0;i<V;i++){
              for(int[] arr:adj.get(i)){
                  int u =i;
                  int v =arr[0];
                  int wt =arr[1];
                  
                  edges.add(new int[]{wt,u,v});
              }
          }
          
          
           Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
          
          DisJointSet d1 =new DisJointSet(V);
          int ans=0;
          
          for(int i=0;i<edges.size();i++){
              int wt =edges.get(i)[0];
              int u =edges.get(i)[1];
              int v =edges.get(i)[2];
              
              if(d1.findparent(u)!=d1.findparent(v)){
                  ans+=wt;
                  d1.union(u,v);
              }
          }
          
          
          return ans;
     
    }

           


}
