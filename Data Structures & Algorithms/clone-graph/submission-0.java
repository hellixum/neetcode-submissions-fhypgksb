/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> stNode = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(stNode.containsKey(node.val)) return stNode.get(node.val);

        ArrayList<Node> neigh = new ArrayList<>();
        Node root = new Node(node.val, neigh);
        stNode.put(node.val, root);
        node.neighbors.forEach(nd -> neigh.add(cloneGraph(nd)));
        return root;
    }
}