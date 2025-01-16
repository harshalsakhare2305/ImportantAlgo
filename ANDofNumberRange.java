//https://leetcode.com/problems/bitwise-and-of-numbers-range/?envType=problem-list-v2&envId=bit-manipulation
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
     while(right>left){
        right=(right & (right-1));
     }
     return right;
    }
}


/*class Solution {
    public int rangeBitwiseAnd(int left, int right) {
     while(right>left){
        right=(right & (right-1));
     }
     return right;
    }
}*/

