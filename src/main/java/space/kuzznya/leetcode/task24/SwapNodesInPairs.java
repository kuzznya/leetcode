package space.kuzznya.leetcode.task24;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode actualHead = head.next;
        ListNode prev = null;
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node2 != null) {
            ListNode temp = node2.next;

            node1.next = node2.next;
            node2.next = node1;
            if (prev != null) prev.next = node2;

            prev = node1;
            node1 = temp;
            node2 = temp != null ? temp.next : null;
        }
        return actualHead;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode result = swapNodesInPairs.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
