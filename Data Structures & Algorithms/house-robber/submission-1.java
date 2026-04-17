class Solution {
    public int rob(int[] nums) {
        int numberOfHouses = nums.length;
        int[] maxAmountRobbed = new int[numberOfHouses];
        if(numberOfHouses == 1) return nums[0];
        if(numberOfHouses == 2) return Math.max(nums[0], nums[1]);

        maxAmountRobbed[0] = nums[0];
        maxAmountRobbed[1] = nums[1];
        maxAmountRobbed[2] = nums[2] + nums[0];

        for(int i=3; i<numberOfHouses; i++) {
            maxAmountRobbed[i] = Math.max(maxAmountRobbed[i-2], maxAmountRobbed[i-3]) + nums[i];
        }

        return Math.max(maxAmountRobbed[numberOfHouses-1], maxAmountRobbed[numberOfHouses-2]);
    }
}
