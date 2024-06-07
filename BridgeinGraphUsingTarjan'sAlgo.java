import java.util.*;

class Solution {
    int time = 0;

    public void DFS(int n, List<List<Integer>> adj, int curr, int parent, int[] vis, int[] tin, int[] tlow, List<List<Integer>> ans) {
        vis[curr] = 1;
        tin[curr] = time;
        tlow[curr] = time;
        time++;
        
        for (int it : adj.get(curr)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                DFS(n, adj, it, curr, vis, tin, tlow, ans);
                tlow[curr] = Math.min(tlow[curr], tlow[it]);
                if (tin[curr] < tlow[it]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(curr);
                    temp.add(it);
                    ans.add(temp);
                }
            } else {
                tlow[curr] = Math.min(tlow[curr], tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> ans = new ArrayList<>();
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] tlow = new int[n];

        DFS(n, adj, 0, -1, vis, tin, tlow, ans);

        return ans;
    }
}
