    public ArrayList<int[]> Merge(int[][] meetings) {
        int n = meetings.length;
        ArrayList<int[]> merge = new ArrayList<>();
        
        // Corrected Comparator syntax
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        merge.add(new int[]{meetings[0][0], meetings[0][1]});
        
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] <= merge.get(merge.size() - 1)[1]) {
                int st = Math.min(meetings[i][0], merge.get(merge.size() - 1)[0]);
                int en = Math.max(meetings[i][1], merge.get(merge.size() - 1)[1]);
                
                merge.remove(merge.size() - 1);
                merge.add(new int[]{st, en});
            } else {
                merge.add(new int[]{meetings[i][0], meetings[i][1]});
            }
        }

    return merge;
}
