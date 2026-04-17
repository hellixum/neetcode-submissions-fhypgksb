class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 0) return 0;
        int ans = 1, sgn = 0, ctr = 1;
        for(int i=0; i<arr.length-1; i++) {

            if(arr[i] > arr[i+1]) {
                ctr = (sgn != 1) ? ctr+1:2;
                sgn = 1;
            } else if(arr[i] < arr[i+1]) {
                ctr = (sgn != -1) ? ctr+1:2;
                sgn = -1;
            } else {
                sgn = 0;
                ctr = 1;
            }
            ans = Math.max(ans, ctr);
        }
        return ans;
    }
}