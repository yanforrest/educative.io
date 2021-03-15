class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class LinkedListCycleLength {

   public static int findCycleLength(ListNode head){
      ListNode slow = head;
      ListNode fast = head;
      boolean hasCycle = false;
      int cycleNumber = 0;

      while (fast != null && fast.next != null) {
         fast = fast.next.next;
         slow = slow.next;
         if (slow == fast) {
            hasCycle = true; // found the cycle
             break;
         }

      }
      if(hasCycle){
         ListNode cur = slow.next;
         cycleNumber = 1;
         while(cur != slow) {
            cycleNumber++;
            cur = cur.next;
         }
         return cycleNumber;
      }else{
         return 0;
      }
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);
      head.next.next.next.next.next.next = head.next.next;
      System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

      head.next.next.next.next.next.next = head.next.next.next;
      System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
   }
}