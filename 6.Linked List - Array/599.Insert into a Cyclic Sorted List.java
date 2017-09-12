// Self
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        
        ListNode p = node;
        
        while (p.next != node) {
            if (p.val <= x && x <= p.next.val) {
                break;
            } 
            if ((p.val <= x || x <= p.next.val) && p.val > p.next.val) {
                break;
            }
            p = p.next;
        }
        
        ListNode newNode = new ListNode(x);
        newNode.next = p.next;
        p.next = newNode;
        
        return newNode;
    }
}

**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        //System.out.println(node.next.val);
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        
        ListNode p = node;
        while (p.next != node) {
            if (x >= p.val && x <= p.next.val) {
                break;
            }
            
            if ((p.val > p.next.val) && (x > p.val || x < p.next.val)) {
                break;
            }
            
            p = p.next;
        }
        
        ListNode q = p.next;
        p.next = new ListNode(x);
        p = p.next;
        p.next = q;
        
        return p;
    }
}
