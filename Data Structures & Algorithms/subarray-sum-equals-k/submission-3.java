class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap();
        freq.put(0, 1);

        int sm = 0;
        int ans = 0;

        for(int i=0; i<nums.length; i++) {
            sm += nums[i];
            ans += freq.getOrDefault(sm - k, 0);
            freq.put(sm, freq.getOrDefault(sm, 0) + 1);
        }

        return ans;
    }
}