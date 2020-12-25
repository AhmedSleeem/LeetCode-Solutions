/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* removeElements(struct ListNode* head, int val){
    if(!head)return NULL;
    struct ListNode* ans=head,*cur=NULL;
    
    while(head){
        if(head->val!=val)cur=head;
        if(head->val==val){
            struct ListNode* tmp=head;
                while(tmp&&tmp->val==val){
                    tmp=tmp->next;
                }
            if(!tmp){head=NULL; break;}
            else{
                head->val=tmp->val;
                head->next=tmp->next;
            }
        }
        else  head=head->next;
        
    }
    if(cur) {
        cur->next=NULL;
    }
    else  if(!head||(head&&head->val==val)) ans=NULL;
    return ans;
    

}