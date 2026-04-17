class Solution {
    public int findDuplicate(int[] nums) {
        int idx = 0;
        while(nums[idx] > 0) {
            int temp = nums[idx];
            nums[idx] = 0;
            idx = temp;
        }

        return idx;
    }
}
