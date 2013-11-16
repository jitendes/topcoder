/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
     public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;
        ListNode cur = dummy;
        while (n>0){
            end=end.next;
            n--;
        }
        while (end.next!=null){
            cur=cur.next;
            end=end.next;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }
