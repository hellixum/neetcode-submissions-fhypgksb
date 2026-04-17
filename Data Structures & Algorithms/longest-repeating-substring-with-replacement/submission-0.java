class Solution {
    public int characterReplacement(String s, int k) {
        int[] chFq = new int[26];
        int l = 0, r = 0, ans = 1;
        for(;r<s.length();r++) {
            chFq[s.charAt(r) - 'A']++;
            int max = Arrays.stream(chFq).max().getAsInt();
            int len = r-l+1;
            if(len-max <= k) {
                ans = Math.max(ans, r-l+1);
            } else {
                while(len-max>k) {
                    chFq[s.charAt(l)-'A']--;
                    l++;

                    len = r-l+1;
                    max = Arrays.stream(chFq).max().getAsInt();
                }
            }
        }

        return ans;
    }
}
