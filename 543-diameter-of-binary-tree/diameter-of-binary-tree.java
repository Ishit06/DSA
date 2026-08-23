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
    public int diameterOfBinaryTree(TreeNode root) {
        int maxi[]=new int[1];
        maxi[0]=0;
        FindHeight(root,maxi);
        return maxi[0];
    }
    public int FindHeight(TreeNode root,int[] maxi){
if(root==null){
    return 0;
}
int lt=FindHeight(root.left,maxi);
int rt=FindHeight(root.right,maxi);
 maxi[0]=Math.max(maxi[0],(lt+rt));
return  1+Math.max(lt,rt);
    }
}