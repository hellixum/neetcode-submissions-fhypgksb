class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0, ans=nums.length+1, sum=0;
        for(;r<nums.length; r++) {
            sum += nums[r];
            if(sum >= target) {
                while(sum >= target && l<=r) {
                    ans = Math.min(ans, r-l+1);
                    sum -= nums[l++];
                }
            }
        }
        
        return ans > nums.length ? 0 : ans;
    }
}