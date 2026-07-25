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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean lefttoright = true;

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i=0;i<size;i++){

                TreeNode current = q.poll();
            
                if(lefttoright){
                    list.add(current.val);
                }else{
                    list.add(0,current.val);
                }

                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
            ans.add(list);

            lefttoright = !lefttoright;
            
        }
        return ans;
    }
}