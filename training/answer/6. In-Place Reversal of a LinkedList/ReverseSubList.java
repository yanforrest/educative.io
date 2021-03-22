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
      if(p==q)
         return head;

      // TODO: Write your code here
      ListNode cur=head, prev =null, next = null;
      for(int i = 0; i < p-1; i++ ){
         prev = cur;
         cur = cur.next;
      }

      ListNode lastNodeOfTheFirsPart = prev;
      ListNode lastNodeOfTheSubList = cur;

      prev = null;
      next = null;
      for(int i =0; i < q-p+1; i++ ){
         next = cur.next;
         cur.next = prev;
         prev = cur;
         cur = next;
      }

      if(lastNodeOfTheFirsPart != null)
         lastNodeOfTheFirsPart.next = prev;
     else
         head = prev;

      lastNodeOfTheSubList.next = cur;

      return head;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      ListNode result = ReverseSubList.reverse(head, 1, 4);
      System.out.print("Nodes of the reversed LinkedList are: ");
      while (result != null) {
         System.out.print(result.value + " ");
         result = result.next;
      }
   }
}