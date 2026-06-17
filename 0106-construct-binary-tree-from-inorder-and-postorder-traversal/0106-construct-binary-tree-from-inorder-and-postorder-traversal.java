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
    int pre;
    public Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        pre=postorder.length-1;
        return  build(postorder,0,inorder.length-1);
    }
    private TreeNode build(int[] postorder,int start, int end){
        if(start>end) return null;
        int rootVal= postorder[pre--];
        TreeNode root=new TreeNode(rootVal);
        int mid=map.get(rootVal);
        
       root.right= build(postorder,mid+1,end);
       root.left= build(postorder,start,mid-1);
       return root;
    }
}