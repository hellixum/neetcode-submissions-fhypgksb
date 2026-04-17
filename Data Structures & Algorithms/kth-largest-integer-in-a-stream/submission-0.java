class KthLargest {

    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) pq.remove();
        }

        while (pq.size() < k) pq.add(Integer.MIN_VALUE);
    }
    
    public int add(int val) {
        pq.add(val);
        pq.remove();
        return pq.peek();
    }
}