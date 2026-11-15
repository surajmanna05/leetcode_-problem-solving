class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        // Search in the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search in the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node found
        else {

            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            TreeNode minNode = findMin(root.right);

            root.val = minNode.val;

            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    // Find minimum value in BST
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root ;
    }
}