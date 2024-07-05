import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
       
        Arrays.fill(dp, 1);
        int maxi = 0; // Only one declaration of maxi is needed
        int[] hash = new int[n];
        int last = -1;

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && dp[prev] + 1 > dp[i]) {
                    hash[i] = prev;
                    dp[i] = dp[prev] + 1;
                }
            }

            if (dp[i] > maxi) {
                last = i;
                maxi = dp[i];
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (hash[last] != last) {
            ans.add(nums[last]);
            last = hash[last];
        }
        ans.add(nums[last]); // Add the last element

        Collections.reverse(ans);

        return ans;
    }
}
