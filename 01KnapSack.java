static int knapSack(int W, int wt[], int val[], int n) 
    { 
       int[][] dp =new int[n][W+1];
        for(int i=0;i<=W;i++){
             if(i>=wt[0]){
           dp[0][i]=val[0];
       }
        }
       for(int i=1;i<n;i++){
           for(int j=1;j<=W;j++){
               int pick=0;
               if(j>=wt[i]){
                   pick=val[i]+dp[i-1][j-wt[i]];
               }
               
               int np=dp[i-1][j];
               
               dp[i][j]=Math.max(pick,np);
           }
       }
       
       return dp[n-1][W];
    } 
}
