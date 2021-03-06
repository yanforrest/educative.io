import java.util.*;

class Entry {
   int key;
   int value;

   public Entry(int key, int value) {
      this.key = key;
      this.value = value;
   }
}

class KClosestElements {

   public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
      List<Integer> result = new ArrayList<>();
      // TODO: Write your code here
      PriorityQueue<Entry> maxHeap = new PriorityQueue<Entry>((o1, o2) -> Math.abs(o2.value - X) -Math.abs(o1.value - X)  );

      for(int i =0; i< arr.length; i++){
         maxHeap.add(new Entry(i, arr[i]));
         if( maxHeap.size() > K ){
            maxHeap.poll();
         }
      }
      for(int i = 0; i < K; i++){
         result.add(maxHeap.poll().value);
      }
      return  result;
   }

   public static void main(String[] args) {
      List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
      System.out.println("'K' closest numbers to 'X' are: " + result);

      result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
      System.out.println("'K' closest numbers to 'X' are: " + result);

      result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
      System.out.println("'K' closest numbers to 'X' are: " + result);
   }
}