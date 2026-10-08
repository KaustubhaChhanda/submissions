/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();

        dfs(root, 0, new ArrayList<>(), targetSum);

        return res; 
    }

    private void dfs(TreeNode root, int sum, List<Integer> list, int targetSum) {
        if (root == null) return;

        sum += root.val;
        list.add(root.val);

        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(new ArrayList<>(list));
        }

        dfs(root.left, sum, list, targetSum);
        dfs(root.right, sum, list, targetSum);

        list.remove(list.size() - 1);
    }
}