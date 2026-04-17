class Solution {
    class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
        for(int i=0; i<n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(List<Integer> edge : edges) {
            Integer s = edge.get(0), d = edge.get(1), dist = edge.get(2);
            adj.get(s).add(new Pair(d, dist));
        }

        Map<Integer, Integer> shortestPath = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.value-b.value);

        minHeap.offer(new Pair(src, 0));

        while(!minHeap.isEmpty()) {
            Pair<Integer, Integer> curr = minHeap.poll();
            Integer w1 = curr.value, n1 = curr.key;

            if(shortestPath.containsKey(n1)) continue;
            shortestPath.put(n1, w1);

            for(Pair<Integer, Integer> edge: adj.get(n1)) {
                Integer n2 = edge.key, w2 = edge.value;
                if(!shortestPath.containsKey(n2)) {
                    minHeap.offer(new Pair(n2, w1+w2));
                }
            }
        }

        for(int i=0; i<n; i++) {
            shortestPath.putIfAbsent(i, -1);
        }

        return shortestPath;

    }  
}
