class Solution {
    public int[] replaceElements(int[] arr) {
        int mx = -1;
        for(int i=arr.length-1; i>=0; i--) {
            int temp = arr[i];
            arr[i] = mx;
            mx = Math.max(temp, mx);
        }
        
        return arr;
    }
}