import java.util.*;

class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class ReverseEveryAlternatingKElements {

   public static ListNode reverse(ListNode head, int k) {
      if(k<=1 || head == null) return head;

      // TODO: Write your code here
      ListNode cur = null,  next= null, prev = null;
      ListNode lastNodeOfPreviousPart = null;
      ListNode lastNodeOfTheSubList = head;

      cur = lastNodeOfTheSubList;
      while(cur != null) {
         /* 1. reverse the sublist*/
         cur = lastNodeOfTheSubList;
         prev = null;
         next = null;
         for (int i = 0; cur != null &&  i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
         }
         /* 2. connect the reversed sublist with the previous part and next part */
         // hook with the previous part
         if( lastNodeOfPreviousPart == null) {
            head = prev;
         }else {
            lastNodeOfPreviousPart.next = prev;
         }
         // hook with the next part.
         lastNodeOfTheSubList.next = cur;

         for (int i = 0; cur != null &&  i < k; i++) {
            prev = cur;
            cur = cur.next;
         }

         /* 3. renew the two hooker: previous part, and the sublist one*/
         lastNodeOfPreviousPart = prev;
         lastNodeOfTheSubList = cur;
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

      ListNode result = ReverseEveryAlternatingKElements.reverse(head, 3);
      System.out.print("Nodes of the reversed LinkedList are: ");
      while (result != null) {
         System.out.print(result.value + " ");
         result = result.next;
      }
   }
}