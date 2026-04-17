class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int[] leftSum = new int[nums.length], rightSum = new int[nums.length];
        for(int i=1; i<nums.length; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];

            int rp = nums.length-i-1;
            rightSum[rp] = rightSum[rp+1]+nums[rp+1];
        }
        
        for(int i=0; i<nums.length; i++) {
            if(leftSum[i] == rightSum[i]) return i;
        }

        return -1;
    }
}