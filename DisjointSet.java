

class DisjointSetRank {
       
    static class DisJointSet{
        int[] rank;
        int[]parent ;
    
        public DisJointSet(int n){
            rank =new int[n+1];
            parent=new int[n+1];
            for(int i=0;i<=n;i++){
                rank[i]=0;
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
            if(rank[ulp_u] < rank[ulp_v]){
                parent[u]=ulp_v;
            }else if(rank[ulp_u] > rank[ulp_v]){
                parent[v]=ulp_u;
            }else{
                parent[v]=ulp_u;
                rank[ulp_u]++;
            }
    }
    }
    public static void main(String[] args) {
        
        DisJointSet d1 =new DisJointSet(5);
        d1.union(1, 2);
        d1.union(4, 5);
        d1.union(1,3);
        if(d1.findparent(1)==d1.findparent(5)){
            System.out.println("Smae");
        }else{
            System.out.println("Not Same");
        }

        d1.union(3,4);

        if(d1.findparent(1)==d1.findparent(5)){
            System.out.println("Smae");
        }else{
            System.out.println("Not Same");
        }
        
        System.out.println(d1.findparent(1));
         System.out.println(d1.findparent(5));
        
    }
    
}





// BY SIZE
// BY SIZE
// BY SIZE
// BY SIZE
// BY SIZE
// BY SIZE
// BY SIZE
// BY SIZE






class DisjointSetRank {
       
    static class DisJointSet{
        int[] size;
        int[]parent ;
    
        public DisJointSet(int n){
            size =new int[n+1];
            parent=new int[n+1];
            for(int i=0;i<=n;i++){
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
                parent[u]=ulp_v;
                size[ulp_v]+=size[ulp_u];
            }else{
                parent[v]=ulp_u;
                size[ulp_u]+=size[ulp_v];
            }
    }
    }
    public static void main(String[] args) {
        
        DisJointSet d1 =new DisJointSet(5);
        d1.union(1, 2);
        d1.union(4, 5);
        d1.union(1,3);
        if(d1.findparent(1)==d1.findparent(5)){
            System.out.println("Smae");
        }else{
            System.out.println("Not Same");
        }

        d1.union(3,4);

        if(d1.findparent(1)==d1.findparent(5)){
            System.out.println("Smae");
        }else{
            System.out.println("Not Same");
        }
        
        System.out.println(d1.findparent(1));
         System.out.println(d1.findparent(5));
        
    }
    
}
