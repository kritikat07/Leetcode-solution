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
    int preIndex;
    public  Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
       for(int i=0;i<inorder.length;i++){
        map.put(inorder[i],i);
       }
       int preIndex=0;
        return build(preorder,0,preorder.length-1);

    }
    private TreeNode build(int preorder[],int start,int end){
        if(start>end) return null ;
         int rootVal= preorder[preIndex++];
         TreeNode root= new TreeNode(rootVal);
         int mid= map.get(rootVal);
          root.left=build(preorder,start,mid-1);
          root.right=build(preorder,mid+1,end);
        return root;
    }
}