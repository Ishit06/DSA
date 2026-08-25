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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store index of each value in inorder
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1, map);
    }

    public TreeNode build(int[] preorder, int ps, int pe,
                          int[] inorder, int is, int ie,
                          HashMap<Integer, Integer> map) {

        // No elements
        if (ps > pe || is > ie) {
            return null;
        }

        // First element of preorder is root
        int rootValue = preorder[ps];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = map.get(rootValue);

        // Number of elements in left subtree
        int leftSize = rootIndex - is;

        // Build left subtree
        root.left = build(preorder,
                          ps + 1,
                          ps + leftSize,
                          inorder,
                          is,
                          rootIndex - 1,
                          map);

        // Build right subtree
        root.right = build(preorder,
                           ps + leftSize + 1,
                           pe,
                           inorder,
                           rootIndex + 1,
                           ie,
                           map);

        return root;
    }

}