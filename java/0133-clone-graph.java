package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <pre>
 * 
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
 * 
 * </pre>
 */
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


/**
 * <pre>
 * 
 * DFS
 * 
 * </pre>
 */
class Solution1 {
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


/**
 * <pre>
 * 
 * BFS
 * 
 * </pre>
 */
class Solution2 {
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
