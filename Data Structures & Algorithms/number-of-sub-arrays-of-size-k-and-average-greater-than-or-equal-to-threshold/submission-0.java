class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int thrSum = threshold * k;
        int sum = 0, ptr = 0;
        int ans = 0;

        while(ptr<k-1) sum += arr[ptr++];

        while(ptr<arr.length) {
            sum += arr[ptr++];
            if(sum >= thrSum) ans++;

            sum -= arr[ptr-k];
        }

        return ans;        
    }
}


//// [2,5,5,5,8]
//// [0,1,2,3,4]
