package space.kuzznya.leetcode.task25;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode kGroupEnd = skip(cur, k - 1);
            if (kGroupEnd == null) break;
            System.out.println("kGroupEnd " + kGroupEnd.val);
            ListNode kGroupNext = kGroupEnd.next;
            ListNode reversedKGroupHead = reverse(cur, k);
            if (newHead == null) newHead = reversedKGroupHead;
            if (prev != null) prev.next = reversedKGroupHead;
            prev = cur;
            cur = kGroupNext;
        }
        if (prev != null) prev.next = cur;

        return newHead != null ? newHead : head;
    }

    private ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        ListNode cur = head;
        while (k > 0) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;

            k--;
        }
        return newHead;
    }

    private ListNode skip(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
            if (head == null) return null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode result = reverseNodesInKGroup.reverseKGroup(l, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
