package list;

public class MergeTwoSortedList21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode l3mv = l3;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                l3mv.next = l1;
                l3mv = l3mv.next;
                l1 = l1.next;
            }else{
                l3mv.next = l2;
                l3mv = l3mv.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            l3mv.next = l1;
            l3mv = l3mv.next;
            l1 = l1.next;
        }
        while(l2 != null){
            l3mv.next = l2;
            l3mv = l3mv.next;
            l2 = l2.next;
        }
        return l3.next;
    }

    public ListNode mergeTwoListsIter(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsIter(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoListsIter(l1, l2.next);
        return l2;

    }

    public static void main(String[] args){
        MergeTwoSortedList21 mergeTwoSortedList = new MergeTwoSortedList21();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = mergeTwoSortedList.mergeTwoLists(l1, l2);

        ListNode mv = l3;
        String str = "";
        while(mv.next != null){
            str += String.valueOf(mv.val) + "->";
            mv = mv.next;
        }
        str += String.valueOf(mv.val);
        System.out.println(str);
    }
}


