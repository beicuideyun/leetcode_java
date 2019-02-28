package list;

public class RemoveDuplicateFromSortedList82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur != null) {
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(pre.next == cur){
                pre = pre.next;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicatesIter(ListNode head){
        if(head == null) return head;
        if(head.next != null && head.val == head.next.val){
            while(head.next != null && head.val == head.next.val)
                head = head.next;
            return deleteDuplicatesIter(head.next);
        }else{
            head.next = deleteDuplicatesIter(head);
        }
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        RemoveDuplicateFromSortedList82 removeDuplicateFromSortedList82 = new RemoveDuplicateFromSortedList82();
        ListNode mv = removeDuplicateFromSortedList82.deleteDuplicates(head);
        String str = "";
        while(mv.next != null){
            str += String.valueOf(mv.val) + "->";
            mv = mv.next;
        }
        str += String.valueOf(mv.val);
        System.out.println(str);
    }
}
