 public static int[] DijkstrasAlgo(ArrayList<Edge>[] graph,int src,int V){
            PriorityQueue<Pair> pq =new PriorityQueue<>();
          
            int[] distance =new int[V];
            for(int i=0;i<V;i++){
                if(i!=src){
                    distance[i]=Integer.MAX_VALUE;
                }

            }

            pq.add(new Pair(0, 0));

            while (!pq.isEmpty()) {
                Pair curr =pq.remove();
              
                    for(int i=0;i<graph[curr.node].size();i++){
                       Edge e = graph[curr.node].get(i);
                      int u=e.src;
                      int v =e.dest;

                      if(distance[u]+e.wt <distance[v]){
                        distance[v]=distance[u]+e.wt;
                        pq.add(new Pair(v,distance[v]));
                      }
                    }


                
            }
   return distance;
 }







  public int[] DijkstrasAlgo(ArrayList<int[]>[] graph,int src,int V){
            PriorityQueue<int[]> pq =new PriorityQueue<>(((a,b)->a[0]-b[0]));
          
            int[] distance =new int[V+1];
            for(int i=0;i<=V;i++){
                if(i!=src){
                    distance[i]=Integer.MAX_VALUE;
                }

            }
            pq.add(new int[]{0,src});
            

            while (!pq.isEmpty()) {
                int[] curr =pq.remove();
                int node =curr[1];
              
                    for(int i=0;i<graph[node].size();i++){
                       int[] e = graph[node].get(i);
                      
                      int v =e[0];
                      int wt =e[1];

                      if(distance[node]+wt <distance[v]){
                        distance[v]=distance[node]+wt;
                        pq.add(new int[]{distance[v],v});
                      }
                    }


                
            }
   return distance;
 }
