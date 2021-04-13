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
      List<Integer> result = new LinkedList<>();

      int index = binarySearch(arr, X);
      result.add(arr[index]);
      int left = index-1 , right = index+1;

      int i = 1;
      while( i < K){
         if( left < 0) result.add(right++);
         else if( right > arr.length - 1 ) result.add(0, left--);
         else if (Math.abs(arr[left] - X) < Math.abs(arr[right] - X)) {
               result.add(0, arr[left]);
               left--;
         } else {
               result.add(arr[right]);
               right++;
         }
         i++;
      }

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
      if( low > 0) return low - 1 ;

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