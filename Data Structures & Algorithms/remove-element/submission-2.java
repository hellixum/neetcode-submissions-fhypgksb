class Solution {
    public int removeElement(int[] nums, int val) {
        int lft = 0, rgt = nums.length-1;

        while(lft < rgt) {
            if(nums[rgt] == val) {
                rgt--;
            }else if(nums[lft] == val) {
                int temp = nums[lft];
                nums[lft] = nums[rgt];
                nums[rgt] = temp;
                lft++;
                rgt--;
            } else {
                lft++;
            }
        }
        while(lft < nums.length && nums[lft] != val) lft++;

        return lft;
    }
}