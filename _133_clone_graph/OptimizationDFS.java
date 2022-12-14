package _133_clone_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimizationDFS {
    public class Node {
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

    private Map<Node, Node> m = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (m.containsKey(node)) {
            return m.get(node);
        }
        m.put(node, new Node(node.val));
        for (Node neighbor : node.neighbors) {
            m.get(node).neighbors.add(cloneGraph(neighbor));
        }
        return m.get(node);
    }
}
