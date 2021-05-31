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
    
         class Tempo{

        TreeNode node;
        int distance;

            public Tempo(TreeNode node, int distance) {
                this.node = node;
                this.distance = distance;
            }
        }

  boolean bfs(TreeNode root){
        Queue<Tempo>queue=new LinkedList<>();
         queue.add(new Tempo(root,0));
      queue.add(new Tempo(root,0));
         while (!queue.isEmpty()){
             Tempo poll = queue.poll();
             Tempo p = queue.poll();

             if (p.node== null&&poll.node==null)continue;
             if (p.node== null||poll.node==null)return false;
             
             if(p.node.val!=poll.node.val)return false;
             

             queue.add(new Tempo(poll.node.left,0));
             queue.add(new Tempo(p.node.right,0));
             queue.add(new Tempo(poll.node.right,0));
             queue.add(new Tempo(p.node.left,0));


         }
         return true;
  }
    public boolean isSymmetric(TreeNode root) {
            return bfs(root);
    }
}