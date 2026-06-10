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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        sub(root,0,ans);
        return ans;
    }
public void sub(TreeNode root ,int l,List<List<Integer>> ans){
     if(root==null){
        return ;
     }
     if(ans.size()==l){
        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        ans.add(list);

     }
     else{
        ans.get(l).add(root.val);
     }
     sub(root.left,l+1,ans);
     sub(root.right,l+1,ans);
    }
}