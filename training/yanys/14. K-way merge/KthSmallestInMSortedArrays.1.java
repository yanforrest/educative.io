import java.util.*;

class ListNode
{
   int value;
   ListNode next;
   ListNode(int value){
      this.value = value;
   }
}

class KthSmallestInMSortedArrays {

   public static int findKthSmallest(List<Integer[]> lists, int k) {
      // TODO: Write your code here
      ListNode[] listNodes = new ListNode[lists.size()];
      for(int i =0; i < lists.size() ; i++){
         Integer[] values = lists.get(i);
         ListNode tail;
         listNodes[i] = tail = new ListNode(values[0]);
         for ( int j=1; j < values.length ; j++){
            tail.next = new ListNode(values[j]); tail = tail.next;
         }
      }

      PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

      for(ListNode node : listNodes)
         queue.add(node);
      ListNode tail= null, head=null;
      while(!queue.isEmpty()){
         ListNode cur = queue.poll();
         if(head ==null){
            head = tail = cur;
         }else{
            tail.next = cur; tail = cur;
         }
         if(cur.next != null)
            queue.add(cur.next);
      }
      int i = 1; tail = head;
      while( i++ < k){  tail = tail.next;}

      return tail.value;
   }

   public static void main(String[] args) {
      Integer[] l1 = new Integer[] { 2, 6, 8 };
      Integer[] l2 = new Integer[] { 3, 6, 7 };
      Integer[] l3 = new Integer[] { 1, 3, 4 };
      List<Integer[]> lists = new ArrayList<Integer[]>();
      lists.add(l1);
      lists.add(l2);
      lists.add(l3);
      int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
      System.out.print("Kth smallest number is: " + result + "\n");

      l1 = new Integer[] { 5, 8, 9 };
      l2 = new Integer[] { 1, 7 };
      lists = new ArrayList<Integer[]>();
      lists.add(l1);
      lists.add(l2);
      result = KthSmallestInMSortedArrays.findKthSmallest(lists, 3);
      System.out.print("Kth smallest number is: " + result);
   }
}