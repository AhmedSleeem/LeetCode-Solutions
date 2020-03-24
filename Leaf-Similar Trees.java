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
      ArrayList<Integer>list = new ArrayList<>(),list2=new ArrayList<>();
    void dfs(TreeNode node){
        if(node==null)return;
        if (node.left==null&&node.right==null){
            list.add(node.val);
            return;
        }
        dfs(node.left);
        dfs(node.right);
    }
    void bfs(TreeNode node){
        if(node==null)return;
        if (node.left==null&&node.right==null){
            list2.add(node.val);
            return;
        }
        bfs(node.left);
        bfs(node.right);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1);
        bfs(root2);
         System.out.println(list);
        System.out.println(list2);
        if (list.size()!=list2.size())return false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)!=list2.get(i))return false;
        }
        return true;
    }
}