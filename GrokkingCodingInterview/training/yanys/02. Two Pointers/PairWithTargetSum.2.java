import java.util.*;

class PairWithTargetSum {

   public static int[] search(int[] arr, int targetSum) {
      HashMap<Integer,Integer>  nums = new HashMap<>();

      for ( int i = 0; i < arr.length; i++){
         if(nums.containsKey(targetSum-arr[i]))
            return new int[]{i,nums.get(targetSum-arr[i])};
         else
            nums.put(arr[i], i);
      }
      return new int[] {-1, -1};
   }

   public static void main(String[] args) {
      int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
      System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
      result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
      System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
   }
}