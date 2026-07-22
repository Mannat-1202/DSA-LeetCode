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
    public boolean hasPathSum(TreeNode root, int targetSum) {
       return solve(root,targetSum);

    }
    public boolean solve(TreeNode root , int targetSum){
        if(root == null ) return false;

        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }

        boolean  left = solve(root.left,targetSum - root.val);
        boolean right = solve(root.right,targetSum - root.val);

        

        return left || right;

    }
}