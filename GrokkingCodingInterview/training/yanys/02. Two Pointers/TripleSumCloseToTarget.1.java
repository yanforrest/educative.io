import com.sun.scenario.effect.Brightpass;

import java.util.*;

class TripletSumCloseToTarget {

   public static int searchTriplet(int[] arr, int targetSum) {
      // TODO: Write your code here
      int minDiff = Integer.MAX_VALUE;
      Arrays.sort(arr);

      for (int i = 0; i < arr.length-2 ; i++ ){
         int diff = searchPair(arr, targetSum-arr[i], i + 1 );
         if( Math.abs( diff ) < Math.abs(minDiff)){
            minDiff = diff;
         };
      }
      return minDiff + targetSum;
   }
   public static int searchPair(int[] arr, int targetSum, int left){
      int right = arr.length-1;
      int minDiff = Integer.MAX_VALUE;

      while(left < right){
         int diff = arr[left] + arr[right] - targetSum;

         if( diff == 0 ){
            break;
         } else if( diff > 0){
            right --;
         } else {
            left ++;
         }
         if (Math.abs(diff) < Math.abs(minDiff)) {
            minDiff = diff;
         }
      }
      return minDiff;
   };

   public static void main(String[] args) {
      System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
      System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
      System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
   }

}