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
      int index = binarySearch(arr, X);
      int low = index - K, high = index + K;

      if (low <= 0) low = 0;
      if (high > arr.length - 1 ) high = arr.length - 1;

      PriorityQueue<Entry> maxHeap = new PriorityQueue<>((o1, o2) -> o1.key -o2.key);

      for(int i = low; i <= high ; i++){
         Entry cur = new Entry(Math.abs(arr[i]-X), arr[i]);
         maxHeap.add(cur);
      }
      List<Integer> result = new LinkedList<>() ;
      for( int i = 0; i < K; i++){
         result.add(maxHeap.poll().value);
      }
      Collections.sort(result);
      return result; 
   }

   private static int binarySearch(int[] arr, int target) {
      int low = 0;
      int high = arr.length - 1;
      while( low <= high){
         int middle = low + (high - low)/2;
         if( arr[middle] > target){
            high = middle -1;
         }else if ( arr[middle] < target){
            low = middle + 1;
         } else {
            return middle;
         }
      }
      return low;
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