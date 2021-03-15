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
      int cycleLength = findCycleLength(head);

      if (cycleLength== 0) return null;

      ListNode p1 = head, p2 = head;

      while( 0 != cycleLength--)
         p2=p2.next;

      while( p1 != p2){
         p1 = p1.next;
         p2 = p2.next;
      }

      return p1;
   }
   public static int findCycleLength(ListNode head) {
      ListNode slow = head, fast = head, cur;
      int cycleLength = 0;

      while(fast.next != null && fast.next.next!=null ) {
         fast = fast.next.next;
         slow = slow.next;
         if(slow==fast){
            cur = slow.next; cycleLength = 1;
            while(cur!=slow){
               cur = cur.next;
               cycleLength++;
            }
            return cycleLength;
         }
      }
      return 0;
   }

   public static void main(String[] args) {
      ListNode result;
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);

      head.next.next.next.next.next.next = head.next.next;
      System.out.println("LinkedList cycle start: " + ((result = LinkedListCycleStart.findCycleStart(head))== null ? -1 : result.value));

      head.next.next.next.next.next.next = head.next.next.next;
      System.out.println("LinkedList cycle start: " + ((result = LinkedListCycleStart.findCycleStart(head))== null ? -1 : result.value));

      head.next.next.next.next.next.next = head;
      System.out.println("LinkedList cycle start: " + ((result = LinkedListCycleStart.findCycleStart(head))== null ? -1 : result.value));

      head.next.next.next.next.next.next = null;
      System.out.println("LinkedList cycle start: " + ((result = LinkedListCycleStart.findCycleStart(head))== null ? -1 : result.value));
   }
}