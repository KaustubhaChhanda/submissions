class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] e : invocations) {
            edges.get(e[0]).add(e[1]);
        }

        boolean[] suspicious = new boolean[n];
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(k);
        suspicious[k] = true;
        set.add(k);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : edges.get(node)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    set.add(next);
                    q.offer(next);
                }
            }
        }

        boolean[] visited = new boolean[n];
        boolean possible = true;

        for (int i = 0; i < n && possible; i++) {
            if (!suspicious[i] && !visited[i]) {
                q.offer(i);
                visited[i] = true;

                while (!q.isEmpty() && possible) {
                    int node = q.poll();

                    for (int next : edges.get(node)) {
                        if (suspicious[next]) {
                            possible = false;
                            break;
                        }

                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (!possible) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!suspicious[i]) {
                    ans.add(i);
                }
            }
        }

        return ans;
    }
}