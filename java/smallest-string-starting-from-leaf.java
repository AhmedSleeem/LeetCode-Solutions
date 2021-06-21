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
    PriorityQueue<String> queue;

    void dfs(TreeNode node, StringBuilder tmp){
        if (node==null)return;
        StringBuilder t = new StringBuilder(tmp).append((char)(node.val+'a'));
        if (node.left==null&&node.right==null){
          queue.add(t.reverse().toString());
            return;
        }
        dfs(node.left,t);
        dfs(node.right,t);
    }
    public String smallestFromLeaf(TreeNode root) {

        queue = new PriorityQueue();
        dfs(root,new StringBuilder());
        
        return queue.poll();
    }
}