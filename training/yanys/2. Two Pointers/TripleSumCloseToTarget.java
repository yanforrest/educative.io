import com.sun.scenario.effect.Brightpass;

import java.util.*;

class TripletSumCloseToTarget {

   public static int searchTriplet(int[] arr, int targetSum) {
      if(arr == null || arr.length < 3)
         throw new IllegalArgumentException();

      // TODO: Write your code here


      Arrays.sort(arr);
      int minDiff = Integer.MAX_VALUE;

      for (int i = 0; i < arr.length-2 ; i++ ){

         //int diff = targetSum-arr[i] searchPair(arr, targetSum-arr[i], i + 1 );

         int left = i + 1, right = arr.length-1;
         while(left < right){
            int diff = arr[left] + arr[right] + arr[i] - targetSum;

            if( diff == 0 ){
               break;
            } else if( diff > 0){
               right --;
            } else {
               left ++;
            }
            if (Math.abs(diff) < Math.abs(minDiff) || Math.abs(diff) == Math.abs(minDiff) &&  diff < minDiff ) {
               minDiff = diff;
            }
         }

      }
      return minDiff + targetSum;
   }

   public static void main(String[] args) {
      System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
      System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
      System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
   }

}