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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> answer = new ArrayList<>();
        if(root == null) {
           return answer;
            
        }
        answer.addAll(inorderTraversal(root.left));
        answer.add(root.val);
        answer.addAll(inorderTraversal(root.right));

        return answer;
    }
}