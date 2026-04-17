class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = 0, l=0;
        for(int i=0; i<s.length(); i++) {
            int vl = hm.getOrDefault(s.charAt(i), 0);
            
            if(vl == 1) {
                while(l<i && s.charAt(l) != s.charAt(i)) {
                    hm.put(s.charAt(l), 0);
                    l++;
                }
                l++;
            } else {
                ans = Math.max(ans, i-l+1);
                hm.put(s.charAt(i), 1);
            }
        }
        return ans;
    }
}
