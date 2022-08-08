/**
 * Link: https://leetcode.com/problems/add-two-numbers/
 *
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean hasExtra = false;

        ListNode firstNode = null;
        ListNode currentNode = new ListNode();
        ListNode previousNode = null;

        while(true){
            if(firstNode == null) firstNode = currentNode;

            int value = l1.val + l2.val;
            if(hasExtra) value++;

            if(value >= 10){
                value -=10;
                hasExtra = true;
            }else{
                hasExtra = false;
            }

            currentNode.val = value;
            currentNode.next = new ListNode();

            previousNode = currentNode;
            currentNode = previousNode.next;

            if(l1.next == null && l2.next == null && !hasExtra) break;

            l1 = getSafeListNode(l1.next);
            l2 = getSafeListNode(l2.next);

        }

        previousNode.next = null;

        return firstNode;
    }

    private ListNode getSafeListNode(ListNode node){
        return node == null ? new ListNode(0, null) : node;
    }
}
