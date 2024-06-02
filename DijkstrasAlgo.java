 public static int[] DijkstrasAlgo(ArrayList<Edge>[] graph,int src,int V){
            PriorityQueue<Pair> pq =new PriorityQueue<>();
            boolean[] vis =new boolean[V];
            int[] distance =new int[V];
            for(int i=0;i<V;i++){
                if(i!=src){
                    distance[i]=Integer.MAX_VALUE;
                }

            }

            pq.add(new Pair(0, 0));

            while (!pq.isEmpty()) {
                Pair curr =pq.remove();
                if(vis[curr.node]==false){
                    vis[curr.node]=true;
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
            }
   return distance;
 }
