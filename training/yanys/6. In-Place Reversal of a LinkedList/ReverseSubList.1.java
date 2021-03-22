import java.util.*;

class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class ReverseSubList {

   public static ListNode reverse(ListNode head, int p, int q) {
      // TODO: Write your code here
      ListNode begin=head;
      ListNode end=null;
      int i = 1;

      while(i < p-1) {
         begin = begin.next;
         i++;
      }
      end = begin.next;

      ListNode cur  = end;
      ListNode next = cur.next;
      ListNode prev =null;
      while( i < q){
         next = cur.next;
         cur.next = prev;
         prev = cur;
         cur = next;
         i++;
      }

      begin.next = prev;
      end.next = cur;

      return head;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      ListNode result = ReverseSubList.reverse(head, 3, 5);
      System.out.print("Nodes of the reversed LinkedList are: ");
      while (result != null) {
         System.out.print(result.value + " ");
         result = result.next;
      }
   }
}