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
    List<String> list;

    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, new StringBuilder());

        return list;    
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            String s = String.valueOf(root.val);
            sb.append(s);
            list.add(sb.toString());
            sb.delete(sb.length() - s.length(), sb.length());
            return;
        }

        String s = String.valueOf(root.val);
        sb.append(s);
        sb.append("->");
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.delete(sb.length() - s.length() - 2, sb.length());
    }
}