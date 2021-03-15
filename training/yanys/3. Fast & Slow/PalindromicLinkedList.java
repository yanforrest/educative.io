
class ListNode {
   int value = 0;
   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}

class PalindromicLinkedList {

   public static boolean isPalindrome(ListNode head) {
      // TODO: Write your code here
      ListNode slow = head, fast = head;
      while( fast != null && fast.next != null){
         fast = fast.next.next;
         slow = slow.next;
      }
      //
      ListNode rev = reverse(slow);
      ListNode p2 = rev;
      ListNode p1 = head;
      while(p1 != null && p2 != null){
         if(p1.value != p2.value){
           break;
         }
         p1 = p1.next;
         p2 = p2.next;
      }
      reverse(rev);

      if( p1 == null || p2 == null) return true;
      else return false;
   }
   public static ListNode reverse(ListNode head){
      ListNode prev = null;

      while(head != null ){
         ListNode next = head.next;
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
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(2);
      System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

      head.next.next.next.next.next = new ListNode(2);
      System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
   }
}