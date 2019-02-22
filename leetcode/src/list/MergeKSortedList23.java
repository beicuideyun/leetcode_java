package list;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList23 {
    private MergeTwoSortedList21 mergeTwoSortedList21;
    MergeKSortedList23(){
        mergeTwoSortedList21 = new MergeTwoSortedList21();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //时间复杂度O(nlogk), logk为排序时间复杂度，merge复杂度为n（两个list的数量总和）
        if(lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }
    private ListNode sort(ListNode[] lists, int lo, int hi){
        if(lo >= hi) return lists[lo];
        int mid = (hi - lo) / 2 + lo;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return mergeTwoSortedList21.mergeTwoLists(l1, l2);
    }

    public ListNode mergeKListsSolution2(ListNode[] lists){
        // 时间复杂度n*k*log(k)    空间复杂度O(k)
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val-o2.val);//升序
        ListNode dummy = new ListNode(0);
        ListNode walk = dummy;

        for(ListNode node: lists){
            if(node != null){
                pq.offer(node);
            }
        }
        while (!pq.isEmpty()){
            walk.next = pq.poll();
            walk = walk.next;
            if(walk.next != null){
                pq.add(walk.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        MergeKSortedList23 mergeKSortedList23 = new MergeKSortedList23();
        ListNode res = mergeKSortedList23.mergeKLists(lists);
        ListNode mv = res;
        String str = "";
        while(mv.next != null){
            str += String.valueOf(mv.val) + "->";
            mv = mv.next;
        }
        str += String.valueOf(mv.val);
        System.out.println(str);
    }
}
