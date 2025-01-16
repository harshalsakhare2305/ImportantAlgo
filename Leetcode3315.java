class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans =new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            int num =nums.get(i);
            if(num==2){
                ans[i]=-1;
                continue;
            } 
            // n | (n+1) trick is used to set the last cleared bit 
            // so we done the reverse engineering means we know this operation has setted the last cleared bit 
            //that why we check for first clear bit from right ans since we want the mini we cleared the set bit nearest to fist zero from right 
            // 7 =0000...0111


            int numflip =~(num);
            int n = (numflip & (-numflip)); //Extract the rightmost setbit
            int bit =Integer.SIZE - Integer.numberOfLeadingZeros(n)-2;
            numflip = numflip | (1<<bit);
            numflip =~(numflip);
            ans[i]=numflip;
        }

        return ans;
    }
}
