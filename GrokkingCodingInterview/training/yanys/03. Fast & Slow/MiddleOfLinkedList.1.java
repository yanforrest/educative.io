
class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class MiddleOfLinkedList {

   public static ListNode findMiddle(ListNode head) {
      // TODO: Write your code here
      ListNode cur = head;
      int nodeCount = 0;
      // first, get the node number of the whole node list.
      while ( cur.next != null){
         cur = cur.next;
         nodeCount++;
      }
      nodeCount = ( nodeCount + 1) >> 1;
      cur = head;
      int count = 0;

      while(count < nodeCount) {
         cur = cur.next;
         count++ ;
      }

      return cur;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

      head.next.next.next.next.next = new ListNode(6);
      System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

      head.next.next.next.next.next.next = new ListNode(7);
      System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
   }
}