/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //SOLUTION 1;

        // if(root==null) return null;
        // if(root==p || root ==q) return root;
        // TreeNode left=lowestCommonAncestor( root.left,  p,q) ;
        // TreeNode right=lowestCommonAncestor( root.right,  p,q) ;
        // if(left!=null && right!=null){
        //     return root;
        // }
        // else if(left!=null){
        //     return left;
        // }
        // else{
        //     return right;
        // }
         
        // SOLUTION 2;
        int small=Math.min(p.val,q.val);
        int large=Math.max(p.val,q.val);
        while(root!=null){
            if(large<root.val) {
                root=root.left;
            }
            else if(small> root.val){
                root=root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }
}