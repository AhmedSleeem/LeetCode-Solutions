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
    List<List<Integer>>ans;
    int max;
    
    void  check(List<Integer>a,TreeNode node,int curSum){
       
        
        if (curSum+node.val ==max&&
            node.right==null&&node.left==null){
            
             List<Integer>temp1=new ArrayList<>(a);
        temp1.add(node.val);
            ans.add(temp1);
            return;
        }
       
      
        List<Integer>temp=new ArrayList<>(a);
        temp.add(node.val);
       
     
        
          if(node.right!=null)  check(temp,node.right,curSum+node.val);
          if(node.left!=null) check(temp,node.left,curSum+node.val);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans=new ArrayList<>() ;
        if (root==null)return ans;
        max=sum;
       check(new ArrayList<>(),root,0);
        return ans;
    }
  
}