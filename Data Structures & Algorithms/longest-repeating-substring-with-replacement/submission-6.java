class Solution {
    public int characterReplacement(String s, int k) {
        int[] chFq = new int[26];
        int l = 0, r = 0, ans = 1, max = 0;
        for(;r<s.length();r++) {
            chFq[s.charAt(r) - 'A']++;
            max = Math.max(max, chFq[s.charAt(r) - 'A']);
            int len = r-l+1;
            
            if(len-max>k) {
                chFq[s.charAt(l)-'A']--;
                l++;

                len = r-l+1;
            }

            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }
}
