 class DisJointSet{
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
                parent[ulp_u]=ulp_v;
            }else if(rank[ulp_u] > rank[ulp_v]){
                parent[ulp_v]=ulp_u;
            }else{
                parent[ulp_v]=ulp_u;
                rank[ulp_u]++;
            }
    }
    }
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n =accounts.size();
        DisJointSet d1 =new DisJointSet(n);
        HashMap<String,Integer> mp =new HashMap<>();
        for(int i=0;i<n;i++){
           for(int j=1;j<accounts.get(i).size();j++){
            String mail =accounts.get(i).get(j);
            if(!mp.containsKey(mail)){
                mp.put(mail,i);
            }else{
                d1.union(i,mp.get(mail));
            }
           }
        }


        List<String>[] temp =new List[n]; 

        for(int i=0;i<n;i++){
            temp[i]=new ArrayList<>();
        }
        for(String s:mp.keySet()){

            int idx =d1.findparent(mp.get(s));
            temp[idx].add(s);
        }

        List<List<String>> ans =new ArrayList<>();
        for(int i=0;i<n;i++){
            List<String> t =new ArrayList<>();
            if(temp[i].size()!=0){
            t.add(accounts.get(i).get(0));
            Collections.sort(temp[i]);
              t.addAll(temp[i]);
              ans.add(t);
            }
            
        }
     return ans;
    }
}
