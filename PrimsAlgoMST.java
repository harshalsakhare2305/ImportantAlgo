 static int MST(int V, int E, List<List<int[]>> adj) {
       
       PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->a[0]-b[0]);
       int[] vis =new int[V];
       pq.add(new int[]{0,0});
       int sum=0;
       
       while(!pq.isEmpty()){
           int[] curr =pq.poll();
           int wt =curr[0];
           int node =curr[1];
           
           if(vis[node]==1) continue;
           vis[node]=1;
           sum+=wt;
           
           for(int[] i:adj.get(node)){
               int v =i[0];
               int w =i[1];
               
               if(vis[v]==0){
                   pq.add(new int[]{w,v});
               }
           }
           
         
           
       }
       
         return sum;
    }

           
