/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* deleteDuplicates(struct ListNode* head){
    
    
    struct ListNode* tmp=head,*ans=head;
    while(head){
        while(tmp&&tmp->val==head->val){
            tmp=tmp->next;
        }
            head->next=tmp;
        head=head->next;
    }
    
    return ans;

}