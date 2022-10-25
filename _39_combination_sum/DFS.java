package _39_combination_sum;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return ans;
    }

    private void dfs(int[] cand, int target, List<Integer> comb, int sum, int idx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = idx; i < cand.length; i++) {
            comb.add(cand[i]);
            sum += cand[i];
            dfs(cand, target, comb, sum, i);
            comb.remove(comb.size() - 1);
            sum -= cand[i];
        }
    }
}
