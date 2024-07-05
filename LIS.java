class Solution {
   
      public static  int lowerBOund(List<Integer> nums, int target) {
        int n =nums.size();
        int si =0;
        int ei=n-1;
      int ans=n;
        while(si<=ei){
            int mid =si+(ei-si)/2;
            if(nums.get(mid)>=target){
                ans=mid;
              ei=mid-1;
            } else{
                si=mid+1;
            } 
        }

        return ans;
    }
    
    static int longestSubsequence(int n, int a[]) {
        List<Integer> temp =new ArrayList<>();
        temp.add(a[0]);
        int len=1;
        for(int i=1;i<n;i++){
            if(a[i]>temp.get(temp.size()-1)){
                temp.add(a[i]);
                len++;
            }else{
                int lb =lowerBOund(temp,a[i]);
                temp.set(lb,a[i]);
            }
        }
        
        return len;
    }


//   //Using Tabulation
//     //  int[] dp =new int[n];
//     //  Arrays.fill(dp,1);
//     //  int maxi =Integer.MIN_VALUE;
//     //     for(int i=0;i<n;i++){
//     //         for(int prev=0;prev<i;prev++){
//     //             if(nums[i]>nums[prev]){
//     //                 dp[i]=Math.max(dp[i],dp[prev]+1);
//     //             }
//     //         }

//     //         maxi=Math.max(maxi,dp[i]);
//     //     }
//     //      return maxi;
//     // }
// }
