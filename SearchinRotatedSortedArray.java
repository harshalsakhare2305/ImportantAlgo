class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low =0;
        int high=n-1;

        while(low<=high){
            int mid =(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[low]<=nums[mid]){//Left Part is Sorted
                 if(nums[low]<=target && target<nums[mid]){ //target lies in left part
                      high=mid-1;
                 }else{
                    low=mid+1;
                 }
            }else{  //Right part is Sorted
                if(nums[mid]<target && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }

        return -1;
    }
}
