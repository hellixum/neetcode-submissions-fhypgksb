class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, ctr=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                ctr++;
            } else {
                ans = Math.max(ans, ctr);
                ctr = 0;
            }
        }

        ans = Math.max(ans, ctr);
        return ans;
    }
}