class Solution{
    public List<Integer> shortestPath(int n, int m, int edges[][]){
        ArrayList<int[]>[] adj =new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<int[]>();
        }
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v =edges[i][1];
            int wt =edges[i][2];
            adj[u].add(new int[]{v,wt});
            adj[v].add(new int[]{u,wt});
        }
        
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dis =new int[n+1];
        int[] parent =new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
            dis[i]=(int)1e9;
        }
        
        dis[1]=0;
        
        pq.add(new int[]{1,0});
        while(!pq.isEmpty()){
            int[] curr =pq.poll();
            int node =curr[0];
            
            for(int[] i:adj[node]){
                int v =i[0];
                int wt =i[1];
                if(dis[node]+wt<dis[v]){
                    parent[v]=node;
                    dis[v]=dis[node]+wt;
                    pq.add(new int[]{v,dis[v]});
                }
            }
            
            
        }
        
        List<Integer> list =new ArrayList<>();
        if(dis[n]==(int)1e9){
            list.add(-1);
            return list;
        }
        int num=n;
        
        while(parent[num]!=num){
            list.add(num);
            num=parent[num];
        }
        
        list.add(num);
        list.add(dis[n]);
        Collections.reverse(list);
        return list;
    }
}
