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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        int capacity = hashTable.length;
        if (capacity == 0) {
            return hashTable;
        }
        
        int newCapacity = 2 * capacity;
        ListNode[] newHashTable = new ListNode[newCapacity];
        
        for (int i = 0; i < capacity; i++) {
            ListNode p = hashTable[i];
            while (p != null) {
                int newIndex = hashcode(p.val, newCapacity); 
                
                if (newHashTable[newIndex] == null) {
                    newHashTable[newIndex] = new ListNode(p.val);
                } else {
                    ListNode q = newHashTable[newIndex];
                    while (q.next != null) {
                        q = q.next;
                    }
                    q.next = new ListNode(p.val);
                }
                p = p.next;
            }
        }
        
        return newHashTable;
    }
    
    private int hashcode(int key, int capacity) {
        if (key >= 0) {
            return key % capacity;
        } else {
            return (key % capacity + capacity) % capacity;
        }
    }
};
