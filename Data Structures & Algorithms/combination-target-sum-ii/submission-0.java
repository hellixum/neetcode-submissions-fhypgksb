class Solution {
    Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        makeSubset(candidates, target, 0, 0, new ArrayList<>());
        return new ArrayList(ans);
    }

    void makeSubset(int[] candidates, int target, int pos, int sum, List<Integer> subset) {
        if(sum == target) {
            ans.add(new ArrayList(subset));
            return;
        } else if(sum < target && pos < candidates.length) {
            subset.add(candidates[pos]);
            makeSubset(candidates, target, pos+1, sum+candidates[pos], subset);
            subset.remove(subset.size()-1);
            makeSubset(candidates, target, pos+1, sum, subset);
        }
    }
}