import com.sun.deploy.security.SelectableSecurityManager;

import java.util.*;

class FirstKMissingPositive {

   public static List<Integer> findNumbers(int[] nums, int k) {
      List<Integer> missingNumbers = new ArrayList<>();
      Set<Integer> extraNumbers = new HashSet<>();
      int i = 0;
      while(i < nums.length){
         if( nums[i] > 0 && nums[i] <= nums.length &&  nums[i]!=nums[nums[i]-1] )
            swap(nums, i, nums[i]-1);
         else
            i++;
      }

      for(i = 0; i< nums.length && missingNumbers.size() < k; i++ ){
         if(nums[i] != i+1 ){
            missingNumbers.add(i+1);
            extraNumbers.add(nums[i]);
         }
      }

      int j = nums.length+1;
      while(missingNumbers.size() < k ){
         if(!extraNumbers.contains(j))
            missingNumbers.add(j);
         j++;
      }
      return missingNumbers;
   }

   public static void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
   }

   public static void main(String[] args) {
      System.out.println("Output: " + FirstKMissingPositive.findNumbers(new int[]{3,-1,4,5,5}, 3));
      System.out.println("Output: " + FirstKMissingPositive.findNumbers(new int[]{2,3,4},3));
      System.out.println("Output: " + FirstKMissingPositive.findNumbers(new int[]{-2,-3,4},2));
   }
}