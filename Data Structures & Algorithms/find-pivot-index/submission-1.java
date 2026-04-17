class Solution {
    public int pivotIndex(int[] nums) {
        int total = nums[0];
        int[] leftSum = new int[nums.length];
        for(int i=1; i<nums.length; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
            total+= nums[i];
        }
        
        for(int i=0; i<nums.length; i++) {
            if(leftSum[i] == total-leftSum[i]-nums[i]) return i;
        }

        return -1;
    }
}