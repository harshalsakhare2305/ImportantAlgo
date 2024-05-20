class Solution {
   // Smallest iindex such that arr[index]>target
    public int UpperBound(int[] nums, int target) {
        int n =nums.length;
        int si =0;
        int ei=n-1;
      int ans=n;
        while(si<=ei){
            int mid =si+(ei-si)/2;
            if(nums[mid]>target){
                ans=mid;
              ei=mid-1;
            } else{
                si=mid+1;
            } 
        }

        return ans;
    }
}
