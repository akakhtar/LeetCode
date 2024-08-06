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
    public ListNode sortList(ListNode head) {
        //base case
        if(head == null || head.next == null)
        return head;

        // break the list in two halves
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        //sort the tho halves using recurssion
        left = sortList(left);
        right = sortList(right);

        //merge two sorted list
        ListNode result = merge(left,right);
        return result;
    }

    ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast  = fast.next.next;
        }
        return slow;
    }

    ListNode merge(ListNode left,ListNode right){
        if(left == null) return right;
        if(right == null) return left;

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while(left!=null && right!=null){
            if(left.val < right.val){
                temp.next = left;
                temp = left;
                left = left.next;
            }
            else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }
        while(left!=null){
            temp.next = left;
            temp = left;
            left = left.next;
        }
        while(right!=null){
            temp.next = right;
            temp = right;
            right = right.next;
        }
        ans = ans.next;
        return ans;
    }
}