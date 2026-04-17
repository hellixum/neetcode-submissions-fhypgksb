class Solution {
    class Edge {
        Integer node;
        Integer time;

        Edge(Integer node, Integer time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> adjList = new HashMap<>();
        for(int i=1; i<=n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge: times) {
            adjList.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }

        Map<Integer, Integer> shortestPath = new HashMap<>();
        Queue<Edge> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.time, b.time));
        minHeap.offer(new Edge(k, 0));

        while(!minHeap.isEmpty()) {
            Edge currEdge = minHeap.poll();
            Integer node = currEdge.node, time = currEdge.time;

            if(shortestPath.containsKey(node)) continue;
            shortestPath.put(node, time);

            for(Edge edge: adjList.get(node)) {
                Integer node1 = edge.node, time1 = edge.time;
                if(!shortestPath.containsKey(node1)) {
                    minHeap.offer(new Edge(node1, time+time1));
                }
            }
        }

        Integer ans = 0;
        for(int i=1; i<=n; i++) {
            if(!shortestPath.containsKey(i)) return -1;

            ans = Math.max(ans, shortestPath.get(i));
        }
        
        return ans;
    }
}