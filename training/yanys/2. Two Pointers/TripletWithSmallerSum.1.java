import java.util.*;

class TripletWithSmallerSum {

   public static int searchTriplets(int[] arr, int target) {
      Arrays.sort(arr);

      int count = 0;
      // TODO: Write your code here
      for (int i =0; i < arr.length - 2; i++){
         count += searchPair(arr, target - arr[i], i + 1);
      }
      return count;
   }
   public static int searchPair(int[] arr, int targetSum, int first) {
      int right = arr.length - 1;
      int count = 0;
      int curSum = 0;
      int left = first;
      while (left < right) {
         if (arr[left] + arr[right] < targetSum) {
            count += right - left;

            left++;
         } else {
            right--;
         }
      }
      return count;
   }
   public static void main(String[] args) {
      System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
      System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
   }

}