class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int slw = 0, fst = 0;

        while(fst<nums.length) {
            if(nums[fst] == nums[slw]) {
                fst++;
            } else {
                slw++;
                nums[slw] = nums[fst];
            }
        }

        return slw+1;
    }
}