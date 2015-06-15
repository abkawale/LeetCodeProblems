/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCodeProblems;

import java.util.List;

/**
 *
 * @author Abhay Kawale
 */
public class MergeKSortedLists {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists){
        if (lists==null||lists.isEmpty()){
            return null;
        }
        return mergeKLists(lists, 0, lists.size()-1);
    }
    
    
    /**
     * Divide and Conquer
     * @param lists
     * @param left
     * @param right
     * @return 
     */
    private ListNode mergeKLists(List<ListNode> lists, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            return merge(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
        }
        return lists.get(left);
    }

    
    /**
     * Merge two lists
     * @param n1 - head of list 1
     * @param n2 - head of list 2
     * @return 
     */
    private ListNode merge(ListNode n1, ListNode n2) {

        ListNode m1 = new ListNode(0);
        ListNode m2;

        m2 = m1;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                m1.next = n1;
                n1 = n1.next;
            } else {
                m1.next = n2;
                n2 = n2.next;
            }
            m1 = m1.next;
        }
        if (n2 != null) {
            m1.next = n2;
        } else if (n1 != null) {
            m1.next = n1;
        }
        return m2.next;
    }
}
