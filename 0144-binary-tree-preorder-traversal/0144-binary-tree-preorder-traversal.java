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
    public List<Integer> preorderTraversal(TreeNode root) {
        //  ArrayList<Integer> arrl = new ArrayList<>();
        // if(root == null) return arrl;
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // while(!stack.isEmpty()){
        //     TreeNode current = stack.pop();
        //     arrl.add(current.val);
        //     if(current.right != null){
        //         stack.push(current.right);
        //     }
        //     if(current.left != null){
        //         stack.push(current.left);
        //     }
        // }
        // return arrl;
        List<Integer>list=new ArrayList<>();
          preOrder(root,list);
          return list;

        

    }
    private void preOrder(TreeNode root,List<Integer>list){
        if(root==null) return ;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
}