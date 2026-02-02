package space.kuzznya.leetcode.task19;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode cur = skip(head, n - 1);
        if (cur == null) return null;
        ListNode nodeToRemove = null;
        while (cur.next != null) {
            cur = cur.next;
            nodeToRemove = nodeToRemove != null ? nodeToRemove.next : head;
        }
        if (nodeToRemove == null) return head.next;
        nodeToRemove.next = nodeToRemove.next.next;
        return head;
    }

    private ListNode skip(ListNode head, int n) {
        for (int i = 0; i < n; i++) {
            head = head.next;
            if (head == null) return null;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = removeNthFromEnd.removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

        ListNode head1 = new ListNode(1, new ListNode(2));
        ListNode result1 = removeNthFromEnd.removeNthFromEnd(head1, 2);
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
        System.out.println();
    }
}
