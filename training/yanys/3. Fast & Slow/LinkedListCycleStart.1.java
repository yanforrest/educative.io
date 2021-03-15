class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class LinkedListCycleStart {

   public static ListNode findCycleStart(ListNode head) {
      // TODO: Write your code here
      ListNode slow = head, fast = head, start, cur;
      while( fast.next != null && fast.next.next!= null){
         fast = fast.next.next;
         slow = slow.next;
         if(fast==slow){
            cur = slow.next; start = slow;
            while(slow != cur){
               if ( start.value > cur.value )
                  start = cur;
               cur = cur.next;
            }
            return start;
         }
      }
      return null;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);

      head.next.next.next.next.next.next = head.next.next;
      System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

      head.next.next.next.next.next.next = head.next.next.next;
      System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

      head.next.next.next.next.next.next = head;
      System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);


   }
}