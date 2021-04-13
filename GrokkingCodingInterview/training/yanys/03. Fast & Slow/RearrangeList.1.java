
class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class RearrangeList {

   public static void reorder(ListNode head) {
      // TODO: Write your code here
      ListNode fast=head, slow=head;
      while( fast != null && fast.next != null ){
         fast=fast.next.next;
         slow=slow.next;
      }
      ListNode rev = reverse(slow);
      ListNode p2 = rev;
      ListNode p1 = head;
      ListNode next1;
      ListNode next2;

      while(p1!=null && p2!=null ){

         next1 = p1.next;
         next2 = p2.next;

         if(next1 == null) break;

         p1.next = p2;

         if ( next2 ==  null ) break;

         p2.next = next1;
         
         p1 = next1;
         p2 = next2;
      }

   }

   public static ListNode reverse( ListNode head){
      ListNode prev=null;

      while(head!=null){
         ListNode next =  head.next;
         head.next = prev;
         prev = head;
         head = next;
      }
      return prev;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(2);
      head.next = new ListNode(4);
      head.next.next = new ListNode(6);
      head.next.next.next = new ListNode(8);
      head.next.next.next.next = new ListNode(10);
      head.next.next.next.next.next = new ListNode(12);
      RearrangeList.reorder(head);
      while (head != null) {
         System.out.print(head.value + " ");
         head = head.next;
      }

      System.out.print( "\n");
      head = new ListNode(2);
      head.next = new ListNode(4);
      head.next.next = new ListNode(6);
      head.next.next.next = new ListNode(8);
      head.next.next.next.next = new ListNode(10);
      RearrangeList.reorder(head);
      while (head != null) {
         System.out.print(head.value + " ");
         head = head.next;
      }
   }
}