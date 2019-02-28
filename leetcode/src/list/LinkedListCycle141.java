package list;

public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
        return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next = l1.next;

        LinkedListCycle141 linkedListCycle141 = new LinkedListCycle141();
        boolean mv = linkedListCycle141.hasCycle(l1);
        System.out.println(mv);
    }
}
