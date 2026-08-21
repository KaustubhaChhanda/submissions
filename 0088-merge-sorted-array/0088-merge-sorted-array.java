class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] n1 = new int[m];

        for (int i = 0; i < m; i++) {
            n1[i] = nums1[i];
        }

        int index = 0, left = 0, right = 0;

        while (left < m && right < n) {
            if (n1[left] < nums2[right]) {
                nums1[index++] = n1[left++];
            } else {
                nums1[index++] = nums2[right++];
            }
        }

        while (left < m) {
            nums1[index++] = n1[left++];
        }

        while (right < n) {
            nums1[index++] = nums2[right++];
        }
    }
}