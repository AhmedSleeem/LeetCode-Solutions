/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head  = null,ans=null;
        
        
        int iterations=0;
        while(true){
            ++iterations;
            boolean madeMove = false;
            
            int min = Integer.MAX_VALUE;
            int tmpIndex= 0;
            for(int i = 0;i<lists.length;++i){
                if(lists[i]==null)continue;
                if(lists[i].val<min){
                    madeMove = true;
                    min = lists[i].val;
                    tmpIndex=i;
                }
            }
            if(!madeMove)break;
            lists[tmpIndex] = lists[tmpIndex].next;
            
            if(head==null){
                head = new ListNode(min);
                ans=head;
            }else{
                head.next = new ListNode(min);
                head =head.next;
            }
        }
        
       
        
        
        return ans;
        
        
    }
}