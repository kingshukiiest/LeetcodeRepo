class Solution {
    TreeNode prev;
    int min;
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        if(prev!=null)
        {
            min=Math.min(min,root.val-prev.val);
        }
        prev=root;
        inOrder(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        min=Integer.MAX_VALUE;
        prev=null;
        inOrder(root);
        return min;
    }
}