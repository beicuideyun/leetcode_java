package list;

public class RemoveDuplicateFromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode walk = head;
        while(walk != null){
            if(walk.next == null){
                break;
            }
            if(walk.val == walk.next.val){
                walk.next = walk.next.next;
            }else{
                walk = walk.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicatesIter(ListNode head){
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicatesIter(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        RemoveDuplicateFromSortedList83 removeDuplicateFromSortedList83 = new RemoveDuplicateFromSortedList83();
        ListNode mv = removeDuplicateFromSortedList83.deleteDuplicates(head);
        String str = "";
        while(mv.next != null){
            str += String.valueOf(mv.val) + "->";
            mv = mv.next;
        }
        str += String.valueOf(mv.val);
        System.out.println(str);
    }
}
