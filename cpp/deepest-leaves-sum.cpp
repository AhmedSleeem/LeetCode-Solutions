/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
        int maximum=0,ans=0 ;
    
    void dfs(TreeNode* node,int depth){
        if(node ==NULL ){
            maximum=max(depth,maximum);
            return;
        }
        dfs(node->left,depth+1);
        dfs(node->right,depth+1);
    }
    
      void dfsSum(TreeNode* node,int depth){
        
          if(node->left == NULL){
              if(depth+1 == maximum)ans+=node->val;
                
          }else dfsSum(node->left,depth+1);
          
            if(node->right == NULL){
              if(depth+1 == maximum)ans+=node->val;
              
          }else dfsSum(node->right,depth+1);
       
      }
    
    
  
   
    int deepestLeavesSum(TreeNode* root) {
        
        
        dfs(root,0);
        dfsSum(root,0);
        
        return ans/2;
        
    }
};