class Solution {
    public int rob(int[] nums) {
        int numberOfHouses = nums.length;
        int[] maxAmountRobbed = new int[numberOfHouses];
        if(numberOfHouses == 1) return nums[0];

        maxAmountRobbed[0] = nums[0];
        maxAmountRobbed[1] =  Math.max(nums[0], nums[1]);

        for(int i=2; i<numberOfHouses; i++) {
            maxAmountRobbed[i] = Math.max(maxAmountRobbed[i-1], maxAmountRobbed[i-2]+nums[i]);
        }

        return maxAmountRobbed[numberOfHouses-1];
    }
}
