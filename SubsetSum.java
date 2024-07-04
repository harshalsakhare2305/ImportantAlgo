static Boolean isSubsetSum(int N, int arr[], int sum){
      boolean[][] dp=new boolean[N+1][sum+1];
      for(int i=0;i<=N;i++){
          dp[i][0]=true;
      }
     
      
   
     for(int i=N-1;i>=0;i--){
         for(int j=1;j<=sum;j++){
            boolean p=false;
            if(j>=arr[i]){
                p=dp[i+1][j-arr[i]];
            }
            
            boolean np=dp[i+1][j];
            
            dp[i][j]=p|np;
         }
     }
     
     return dp[0][sum];
      
    }
