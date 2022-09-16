package _133_clone_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class OptimizationBFS {
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
    private Queue<Node> q = new LinkedList<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        m.put(node, new Node(node.val));
        q.offer(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (Node neighbor : n.neighbors) {
                if (!m.containsKey(neighbor)) {
                    m.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                m.get(n).neighbors.add(m.get(neighbor));
            }
        }
        return m.get(node);
    }
}
