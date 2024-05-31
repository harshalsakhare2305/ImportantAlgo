static int[] drow = {-1, 0, 1, 0};
    static int[] dcol = {0, 1, 0, -1};

    public static void iterativeDFS(char[][] map, boolean[][] vis, int r, int c) {
        int n = map.length;
        int m = map[0].length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c});
        vis[r][c] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cr = current[0];
            int cc = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + drow[i];
                int nc = cc + dcol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && map[nr][nc] == '.') {
                    stack.push(new int[]{nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }
    }
