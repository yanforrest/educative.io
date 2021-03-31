import java.util.*;

class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class RotateList {

   public static ListNode rotate(ListNode head, int rotations) {
      // TODO: Write your code here
      if(head == null) return head;

      int number = 0;
      ListNode cur = head;
      ListNode pre = null;
      ListNode result = null;
      int k = 0 ;

      while(cur != null ) {
         pre = cur;
         cur = cur.next;
         k++;
         if(cur == null){
            cur = head;
            pre.next = head;
            number = k;
         }
         if( number !=0){
            if( k == rotations || k ==  number + rotations ) {
               result = cur;
               pre.next = null;
               break;
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);

      ListNode result = RotateList.rotate(head, 3);
      System.out.print("Nodes of the reversed LinkedList are: ");
      while (result != null) {
         System.out.print(result.value + " ");
         result = result.next;
      }

      head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      result = RotateList.rotate(head, 8);
      System.out.print("Nodes of the reversed LinkedList are: ");
      while (result != null) {
         System.out.print(result.value + " ");
         result = result.next;
      }
   }
}