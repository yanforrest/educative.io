import java.util.*;

class QuadrupleSumToTarget {

   public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
      List<List<Integer>> quadruplets = new ArrayList<>();
      // TODO: Write your code here
      Arrays.sort(arr);
      List<Integer> pre = new ArrayList<>();
      for(int i = 0; i < arr.length-3; i++){
         pre.clear(); pre.add(arr[i]);
         searchTriplets(arr, target-arr[i], i+1, quadruplets , pre);
      }
      return quadruplets;
   }

   public static void searchTriplets(int[] arr, int targetSum, int left, List<List<Integer>> triplets, List<Integer> pre){
      int index = pre.size();
      for(int i = left; i < arr.length - 2 ; i++ ){
         pre.add(index, arr[i]);
         searchPair(arr, targetSum - arr[i], i+1, triplets, pre);
         pre.remove(index);
      }
   }
   public static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> pairs, List<Integer>  pre){
      int right = arr.length-1;
      int sum =0;

      while (left < right){
         int leftValue = arr[left], rightValue = arr[right];
         sum = leftValue + rightValue;

         if( sum == targetSum){
            List<Integer> pair =  new ArrayList<Integer>(pre);
            pair.add(arr[left]);
            pair.add(arr[right]);
            pairs.add(pair);

            left ++; right --;
            while(arr[left] == leftValue && left < right) left++;
            while(arr[right] == rightValue && left < right) right--;

         } else if( sum > targetSum) {
            right --;
         } else {
            left ++ ;
         }
      }
   }

   public static void main(String[] args) {

      System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] {4, 1, 2, -1, 1, -3},  1));
      System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] {2, 0, -1, 1, -2, 2},  2));
   }
}