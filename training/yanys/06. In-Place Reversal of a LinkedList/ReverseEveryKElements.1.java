import java.util.*;

class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class ReverseEveryKElements {

   public static ListNode reverse(ListNode head, int k) {
      // TODO: Write your code here
      int i = 0;
      ListNode cur = null, next= null, prev = null;
      ListNode lastNodeOfTheFirstPart = null;
      ListNode lastNodeOfTheSubList = head;
      boolean beFirstSubList = true;

      cur = lastNodeOfTheSubList;
      while(cur != null) {
         cur = lastNodeOfTheSubList;
         prev = null;
         next = null;
         for ( i = 0; cur != null && i < k; i++ ) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
         }
         if( beFirstSubList) {
            head = prev; beFirstSubList = false;
         }else {
            lastNodeOfTheFirstPart.next = prev;
         }
         lastNodeOfTheFirstPart = lastNodeOfTheSubList;
         lastNodeOfTheSubList = cur;
         lastNodeOfTheFirstPart.next = cur;
      }
      return head;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);
      head.next.next.next.next.next.next = new ListNode(7);
      head.next.next.next.next.next.next.next = new ListNode(8);

      ListNode result = ReverseEveryKElements.reverse(head, 3);
      System.out.print("Nodes of the reversed LinkedList are: ");
      while (result != null) {
         System.out.print(result.value + " ");
         result = result.next;
      }
   }
}