class Solution {
      int[] drow ={-1,0,1,0};
      int[] dcol ={0,1,0,-1};
    public void FloodFill(int[][] image, int r, int c, int old ,int newC ,int[][] vis,int[][] ans){
        int  m=image.length;
        int n =image[0].length;
        vis[r][c]=1;
        ans[r][c]=newC;
        for(int i=0;i<4;i++){
            int nr =r +drow[i];
            int nc =c +dcol[i];

            if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && image[nr][nc]==old){
                FloodFill(image,nr,nc,old,newC,vis,ans);
            }
        }

        return;

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int  m=image.length;
        int n =image[0].length;
        int[][] vis =new int[m][n];
        int[][] ans =image;

        FloodFill(image,sr,sc,image[sr][sc],color,vis,ans);

        return ans;

    }
}
