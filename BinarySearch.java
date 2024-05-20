class Solution {
    public int search(int[] nums, int target) {
        int n =nums.length;
        int si =0;
        int ei=n-1;
        while(si<=ei){
            int mid =si+(ei-si)/2;
            if(nums[mid]==target){
                return mid;
            } else if(target > nums[mid]){
                si=mid+1;
            } else{
                ei=mid-1;
            }
        }

        return -1;
    }
}
