public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    /**
     * https://leetcode.com/problems/add-two-numbers/.
     *
     * You are given two non-empty linked lists representing two non-negative integers. The digits are
     * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers
     * and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example 1:
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     *
     * Example 2:
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     *
     * Example 3:
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int curNum = carry;
            if (l1 != null) {
                curNum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                curNum += l2.val;
                l2 = l2.next;
            }
            curNode.next = new ListNode(curNum % 10);
            carry = curNum / 10;
            curNode = curNode.next;
        }
        if (carry != 0) {
            curNode.next = new ListNode(carry);
        }
        return dummy.next;
    }

    private static void print(ListNode l1) {
        while (l1 != null) {
            System.out.print(l1.val);
            l1 = l1.next;
            if (l1 != null) {
                System.out.print("->");
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        // Expects the result as "7->0->8".
        print(AddTwoNumbers.addTwoNumbers(l1, l4));
    }
}
