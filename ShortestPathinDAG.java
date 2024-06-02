class Solution {
   class Pair{
       int dest;
       int wt ;
       Pair(int d,int wt){
           this.dest=d;
           this.wt=wt;
       }
   }
   
      void DFS(int V, ArrayList<ArrayList<Pair>> adj,int start,int[] vis,Stack<Integer>st){
        vis[start]=1;
        for(int i=0;i<adj.get(start).size();i++){
            Pair p =adj.get(start).get(i);
            if(vis[p.dest]==0){
                DFS(V,adj,p.dest,vis,st);
            }
        }
        
        st.push(start);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
		for(int i=0;i<N;i++){
		      adj.add(new ArrayList<Pair>());
		}
		
		for(int i=0;i<M;i++){
		    int u =edges[i][0];
		    int v =edges[i][1];
		    int wt =edges[i][2];
		    
		    adj.get(u).add(new Pair(v,wt));
		}
		
		Stack<Integer> st =new Stack<>();
		int[]vis =new int[N];

    for(int i=0;i<N;i++){
           if(vis[i]==0){
               DFS(N,adj,i,vis,st);
           }
       }
       
       int[] dis =new int[N];
       for(int i=0;i<N;i++){
           dis[i]=(int)1e9;
       }
       
       dis[0]=0;
       while(!st.isEmpty()){
           int u =st.pop();
           
           for(Pair it:adj.get(u)){
               
               int v =it.dest;
               int wt =it.wt;
               if(dis[u]+wt<dis[v]){
                   dis[v]=dis[u]+wt;
               }
           }
           
       }
       
       for(int i=0;i<N;i++){
           if(dis[i]==(int)1e9){
               dis[i]=-1;
           }
       }
       
       return dis;
		
	}
}
