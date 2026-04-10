class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int nextIndex = nums[i] - 1;

            while(nextIndex < nums.length && nextIndex >= 0 && nums[nextIndex] != nextIndex+1) {
                int tempValue = nums[nextIndex];
                nums[nextIndex] = nextIndex+1;

                nextIndex = tempValue-1;
            }
        }

        int ans = nums.length+1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i+1) {
                ans = i+1;
                break;
            }
        }

        return ans;
    }
}