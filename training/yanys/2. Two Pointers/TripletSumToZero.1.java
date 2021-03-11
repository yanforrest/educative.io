import java.util.*;

public class TripletSumToZero {

   public static List<List<Integer>> searchTriplets(int[] arr){
      List<List<Integer>> triplets = new ArrayList<>();
      Arrays.sort(arr);
      
      for(int i = 0; i < arr.length; i ++){
         if(i>0 && arr[i] ==arr[i-1]  )
            continue;
         searchPair(arr, -arr[i], i+1, triplets);
      }
      return triplets;

   }
   public static List<List<Integer>> searchPair(int[] arr, int target, int left,  List<List<Integer>> triplets) {

      int right = arr.length - 1 ;

      while(left < right){
         if( target == arr[left] + arr[right] ) {
               triplets.add(Arrays.asList(-target, arr[i], arr[j]));
               left ++;
               right --;
               while(left < right && arr[left]==arr[left-1])
                  left++;
               while(left < right && arr[right]==arr[right+1])
                  right++;
         } else if(target > arr[left] + arr[right]){
            left++;
         } else {
            right--;
         }

      return triplets;
   }

   public static void main(String[] args) {
      System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
      System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
   }

}
