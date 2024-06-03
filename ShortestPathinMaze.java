class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        if(n==1){
            if(grid[0][0]==0) return 1;
            else return -1;
        }
        int[][] dis =new int[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                dis[i][j]=(int)1e9;
            }
        }

        dis[0][0]=0;
        int[] drow ={-1,-1,0,1,1,1,0,-1};
        int[] dcol = {0,1,1,1,0,-1,-1,-1};
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] curr =q.poll();
            int dist=curr[0];
            int r =curr[1];
            int c =curr[2];
          for(int i=0;i<8;i++){
            int nr =r +drow[i];
            int nc =c +dcol[i];

            if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && dis[r][c]+1<dis[nr][nc]){
                dis[nr][nc]=1+dis[r][c];
                if(nr==n-1 && nc==n-1) return dis[n-1][n-1]+1;
                q.add(new int[]{dis[nr][nc],nr,nc});
            }
          }
        }

        return -1;

    }
}
