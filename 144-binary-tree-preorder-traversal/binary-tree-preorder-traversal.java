import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);          // Visit Root
        preorder(root.left, result);   // Visit Left
        preorder(root.right, result);  // Visit Right
    }
}