/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null) {
            return head;
        }
        
        return quickSort(head);
    }
    
    private ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int target = head.val;
        ListNode m = head;
        ListNode p = head.next;
        
        ListNode left = new ListNode(0);
        ListNode l = left;
        ListNode right = new ListNode(0);
        ListNode r = right;
        
        while (p != null) {
            if (p.val > target) {
                r.next = p;
                r = r.next;
            } else if (p.val < target) {
                l.next = p;
                l = l.next;
            } else {
                m.next = p;
                m = m.next;
            }
            p = p.next;
        }
        r.next = null;
        l.next = null;
        
        ListNode head1 = quickSort(left.next);
        ListNode head2 = quickSort(right.next);
        if (head1 != null) {
            ListNode q = head1;
            while (q.next != null) {
                q = q.next;
            }
            q.next = head;
            
            m.next = head2;
            
            return head1;
        } else {
            m.next = head2;
            return head;
        }
    }
}
