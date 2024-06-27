 public int solveForAlice(int idx,int[] piles,int[] dp){
    if(idx>=piles.length) return 0;
    if(dp[idx]!=-1) return dp[idx];
    int result =Integer.MIN_VALUE;
    int stone=0;
    for(int i=0;i<3;i++){
        if(idx+i<piles.length){
            stone+=piles[idx+i];
            int temp=stone-solveForAlice(idx+i+1,piles,dp);
            result=Math.max(result,temp);
        }
    }

    return dp[idx]=result;
  }
