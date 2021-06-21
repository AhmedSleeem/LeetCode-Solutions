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
    int sum;
    TreeNode test;
    void dfs(TreeNode node,StringBuilder tmp){
        
        if(node==null)return;
        
        StringBuilder r = new StringBuilder(tmp.toString()).append(node.val);
        
        
        if(node.left == null && node.right ==null){
            sum+=Integer.parseInt(r.toString());
            return;
        }
        
        dfs(node.left,r);
        dfs(node.right,r);
        
    
       
    }
    public int sumNumbers(TreeNode root) {
        
        if(root == null)return 0;
        
        test = root;
        dfs(root,new StringBuilder());
        return sum;
    }
}