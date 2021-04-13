import java.util.*;

class KthSmallestNumber {

   public static int findKthSmallestNumber(int[] nums, int k) {
      int previous_min = Integer.MIN_VALUE;
      int previous_index = -1;
      int current_min = Integer.MAX_VALUE;
      int current_index = -1;

      for( int i = 0; i < k ; i++){
         for( int j = 0; j < nums.length; j++){
            if( nums[j] > previous_min && nums[j]  < current_min){
               current_min = nums[j];
               current_index = j;
            } else if( nums[j] == previous_min && j > previous_index ){
               current_min = nums[j];
               current_index = j;
               break;
            }
         }
         previous_min = current_min;
         previous_index = current_index;
         current_min =Integer.MAX_VALUE;
      }
      return previous_min;
   }

   public static void main(String[] args) {
      int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
      System.out.println("Kth smallest number is: " + result);

      // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
      result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
      System.out.println("Kth smallest number is: " + result);

      result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
      System.out.println("Kth smallest number is: " + result);
   }
}