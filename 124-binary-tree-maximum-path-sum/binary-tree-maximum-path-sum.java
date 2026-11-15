class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    int maxGain(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Find maximum gain from left and right
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        // Calculate path sum passing through current node
        int currentSum = root.val + left + right;

        // Update maximum path sum
        maxSum = Math.max(maxSum, currentSum);

        // Return maximum one-sided path
        return root.val + Math.max(left, right);
    }
}