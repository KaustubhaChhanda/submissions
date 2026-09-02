class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = -1;
        right[n - 1] = -1;

        int prevMax = height[0];

        for (int i = 1; i < n; i++) {
            left[i] = prevMax;
            prevMax = Math.max(prevMax, height[i]);
        }

        prevMax = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            right[i] = prevMax;
            prevMax = Math.max(prevMax, height[i]);
        }

        int total = 0;
        
        for (int i = 1; i < n - 1; i++) {
            int minH = Math.min(left[i], right[i]);
            if (minH > height[i]) {
                total += minH - height[i];
            }
        }

        return total;
    }
}