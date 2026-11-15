class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        // Check whether the current node is a leaf
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Subtract current node value
        targetSum = targetSum - root.val;

        return hasPathSum(root.left, targetSum) ||
               hasPathSum(root.right, targetSum);
    }
}

    