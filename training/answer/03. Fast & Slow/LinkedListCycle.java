class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class LinkedListCycle {

   public static boolean hasCycle(ListNode head) {
      // TODO: Write your code here
      ListNode fast=head, slow=head;

      if(fast.next == null) return false;

      fast= fast.next;

      if(fast.next == null) return false;

      fast = fast.next;

      slow = slow.next;

      while ( fast != slow ){
         if(fast.next == null) return false;

         fast= fast.next;

         if(fast.next == null) return false;

         fast = fast.next;

         slow = slow.next;

      }
      return true;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);
      System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

      head.next.next.next.next.next.next = head.next.next;
      System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

      head.next.next.next.next.next.next = head.next.next.next;
      System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
   }
}