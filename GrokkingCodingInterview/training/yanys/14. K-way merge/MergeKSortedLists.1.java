import java.util.*;

class ListNode {
   int value;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class MergeKSortedLists {

   public static ListNode merge(ListNode[] lists) {
      ListNode result = new ListNode(-1);


      PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

      for(ListNode list: lists)
         queue.add(list);

      int finished = 0;
      ListNode prev = result;
      while(finished < lists.length && !queue.isEmpty()){
         ListNode cur = queue.poll();
         if(cur.next!=null) queue.add(cur.next);
         else finished ++;
         prev.next = cur;
         prev = cur;
      }

      return result.next;
   }

   public static void main(String[] args) {
      ListNode l1 = new ListNode(2);
      l1.next = new ListNode(6);
      l1.next.next = new ListNode(8);

      ListNode l2 = new ListNode(3);
      l2.next = new ListNode(6);
      l2.next.next = new ListNode(7);

      ListNode l3 = new ListNode(1);
      l3.next = new ListNode(3);
      l3.next.next = new ListNode(4);

      ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
      System.out.print("Here are the elements form the merged list: ");
      while (result != null) {
         System.out.print(result.value + " ");
         result = result.next;
      }
   }
}
