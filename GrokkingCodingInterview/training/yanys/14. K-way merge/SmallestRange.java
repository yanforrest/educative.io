import java.util.*;

class Node
{
   int elementIndex;
   int arrayIndex;

   Node(int elementIndex, int arrayIndex){
      this.elementIndex = elementIndex;
      this.arrayIndex = arrayIndex;
   }
}

class SmallestRange {

   public static int[] findSmallestRange(List<Integer[]> lists) {

      PriorityQueue<Node> minHeap = new PriorityQueue<Node>((o1, o2) ->
         lists.get(o1.arrayIndex)[o1.elementIndex] - lists.get(o2.arrayIndex)[o2.elementIndex]);

      int currentMaxNumber = Integer.MIN_VALUE;
      for (int i = 0; i < lists.size(); i++){
         currentMaxNumber = Math.max( currentMaxNumber,lists.get(i)[0] );
         minHeap.add( new Node(0,i));
      }

      int start =0;
      int end = currentMaxNumber;
      while(!minHeap.isEmpty() && minHeap.size() == lists.size()) {
         Node cur = minHeap.poll();
         if(end - start > currentMaxNumber - lists.get(cur.arrayIndex)[cur.elementIndex]){
            end = currentMaxNumber;
            start = lists.get(cur.arrayIndex)[cur.elementIndex];
         }

         cur.elementIndex++;
         if (cur.elementIndex < lists.get(cur.arrayIndex).length){
            currentMaxNumber = Math.max(currentMaxNumber, lists.get(cur.arrayIndex)[cur.elementIndex]);
            minHeap.add(cur);
         }

      }
      return new int[] { start, end };
   }

   public static void main(String[] args) {
      Integer[] l1 = new Integer[] { 1, 5, 8 };
      Integer[] l2 = new Integer[] { 4, 12 };
      Integer[] l3 = new Integer[] { 7, 8, 10 };
      List<Integer[]> lists = new ArrayList<Integer[]>();
      lists.add(l1);
      lists.add(l2);
      lists.add(l3);
      int[] result = SmallestRange.findSmallestRange(lists);
      System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
   }
}
