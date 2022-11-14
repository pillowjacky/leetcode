package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * <pre>
 * 
 * 721. Accounts Merge
 * https://leetcode.com/problems/accounts-merge/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Union Find
 * 
 * </pre>
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind(size);

        Map<String, Integer> emailToAccIdx = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            uf.add(i);
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccIdx.containsKey(email)) {
                    uf.union(i, emailToAccIdx.get(email));
                } else {
                    emailToAccIdx.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> mergedAccount = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAccIdx.entrySet()) {
            String email = entry.getKey();
            Integer accIdx = uf.find(entry.getValue());
            mergedAccount.putIfAbsent(accIdx, new TreeSet<>());
            mergedAccount.get(accIdx).add(email);
        }

        List<List<String>> output = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : mergedAccount.entrySet()) {
            List<String> emails = new ArrayList<>(entry.getValue());
            emails.add(0, accounts.get(entry.getKey()).get(0));
            output.add(emails);
        }
        return output;
    }
}


class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
    }

    public void add(int n) {
        parent[n] = n;
        rank[n] = 0;
    }

    // union by rank
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else if (rank[b] < rank[a]) {
            parent[b] = a;
        } else {
            parent[a] = b;
            rank[b]++;
        }
    }

    // path compression
    public int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }
}
