/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up: Can you solve it without using extra space?
 *
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 *
 * Follow up: Can you solve it without using extra space?
 *
 */
package LeetCodeProblems;

/**
 *
 * @author Abhay Kawale
 */
public class LinkedListCycle {

    //Definition for singly-linked list.
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * Detects if list has a cycle
     * @param head
     * @return 
     */
    public boolean hasCycle(ListNode head) {
        return cycleNode(head) != null;
    }

    /**
     * 
     * @param head
     * @return 
     */
    public ListNode detectCycle(ListNode head) {
        ListNode node = cycleNode(head);
        if (node == null) {
            return null;
        }
        ListNode temp = head;
        while (temp != node) {
            node = node.next;
            temp = temp.next;
        }
        return temp;
    }

    /**
     * If it has cycle returns an arbitrary node in the cycle, else returns
     * null.
     *
     * @param head
     * @return
     */
    private ListNode cycleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = movePtr(fast);
            fast = movePtr(fast);
            slow = movePtr(slow);
        } while (fast != slow && fast != null);
        return fast;
    }

    /**
     * Moves ptr to next pos in linked list
     *
     * @param node
     * @return
     */
    private ListNode movePtr(ListNode node) {
        if (node != null) {
            return node.next;
        } else {
            return null;
        }
    }

}
