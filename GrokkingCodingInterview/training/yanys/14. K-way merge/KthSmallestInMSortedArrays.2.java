import java.util.*;

class Node
{
   int arrayIndex;
   int elementIndex;
   Node(int elementIndex, int arrayIndex){
      this.arrayIndex = arrayIndex;
      this.elementIndex = elementIndex;
   }
}
class KthSmallestInMSortedArrays {

   public static int findKthSmallest(List<Integer[]> lists, int k) {

      PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) ->
          lists.get(o1.arrayIndex)[o1.elementIndex] - lists.get(o2.arrayIndex)[o2.elementIndex]);

      for(int i = 0; i< lists.size(); i++)
         minHeap.add(new Node(0, i));

      int i = 0;
      Node cur = null;
      while(!minHeap.isEmpty()){
        cur =  minHeap.poll();
        if(cur.elementIndex < lists.get(cur.arrayIndex).length - 1)
           minHeap.add(new Node(cur.elementIndex + 1, cur.arrayIndex));
        if(++i == k) break;
      }
      return lists.get(cur.arrayIndex)[cur.elementIndex];
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