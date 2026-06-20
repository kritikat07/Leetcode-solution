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
    public TreeNode deleteNode(TreeNode root, int key) {
       if (root==null) return null;
       else if(key> root.val){
       root.right= deleteNode( root.right, key);
       } 
       else if(key< root.val){
        root.left=deleteNode(root.left, key);
       }
       else{
        if(root.right==null && root.left==null){
            return null;
        }
        else if( root.right!=null && root.left==null || root.right==null && root.left!=null){

            return root.right!=null? root.right : root.left;
        }
        else{
            root.val=findmin(root.right);
            root.right=deleteNode(root.right,root.val);
        }
       }
       return root;
    }
    public int findmin(TreeNode root){
        if(root.left==null) return root.val;
        return findmin(root.left);
    }
}