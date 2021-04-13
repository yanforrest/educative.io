import com.sun.deploy.security.SelectableSecurityManager;

import java.util.*;

class KthSmallestNumber {

   public static int findKthSmallestNumber(int[] nums, int k) {

      return findKthSmallestNumberRec(nums, k, 0, nums.length-1);
   }

   public static int findKthSmallestNumberRec(int[] nums, int k, int start, int end) {

       int low = start, high = end;
       int p = partition(nums, low, high);


       if(p != k-1) {
          if (p > k - 1) {
             high = p - 1;

          } else if (p < k - 1) {
             low = p + 1;
          }

          return findKthSmallestNumberRec(nums, k, low, high);
       }

      return nums[k-1];

   }
   static int partition(int[] nums, int low, int high ){

      int pivot = nums[high];

      for( int i = low; i < high; i++){
         if(nums[i] < pivot){
            swap(nums, i, low);
            low ++;
         }
      }
      swap(nums, low, high);
      return low;
   }

   static void swap(int[] nums, int i , int j){
      int temp = nums[j];
      nums[j]=nums[i];
      nums[i]=temp;
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