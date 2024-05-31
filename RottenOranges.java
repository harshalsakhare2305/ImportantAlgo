class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q =new LinkedList<>();
        int[][] vis =new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }

        if(count==0){
            return 0;
        }

        if(q.size()==0){
            return -1;
        }

        int min=-1;
        int[] drow ={-1,0,1,0};
        int[] dcol ={0,1,0,-1};
        while(!q.isEmpty()){
            int size =q.size();

            while(size-->0){
                int[] curr =q.poll();
                int r =curr[0];
                int c =curr[1];
               for(int i=0;i<4;i++){
                int nr =r+drow[i];
                int nc =c +dcol[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1){
                    count--;
                    q.add(new int[]{nr,nc});
                    vis[nr][nc]=2;
                }
               }

            }

            min++;
        }

        if(count==0){
            return min;
        }

        return -1;
    }
}
