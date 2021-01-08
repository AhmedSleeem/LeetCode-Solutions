/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        if(!root)return root;
        Node* ans=root;
        queue<Node*> q;
        q.push(root);
        
        while(q.size()){
            int size=q.size();
            vector<Node*>list;
            for(int i=0;i<size;++i){
                Node *tmp=q.front();
                q.pop();
              
                if(tmp->left)q.push(tmp->left);
                if(tmp->right)q.push(tmp->right);
                 list.push_back(tmp);
            }
            for(int i=0;i<size-1;++i){
                list[i]->next=list[i+1];
            }
            list[list.size()-1]=NULL;
        }
        
        return ans;
    }
};