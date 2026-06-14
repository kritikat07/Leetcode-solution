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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        right(root,ans,0);
        return ans;
    }
    private void right(TreeNode root,List<Integer> ans,int curr){
        if(root==null) return;
        if(curr==ans.size()){
            ans.add(root.val);
        }
        right(root.right,ans,curr+1);
        right(root.left,ans,curr+1);
    }
}