import java.util.*;

class QuadrupleSumToTarget {

   public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
      List<List<Integer>> quadruplets = new ArrayList<>();
      // TODO: Write your code here
      Arrays.sort(arr);
      List<Integer> pre = new ArrayList<>();
      for(int first = 0; first < arr.length-3; first++){
         for ( int second = first + 1; second < arr.length - 2 ; second++   )
         searchPair(arr, target, first,second, quadruplets);
      }
      return quadruplets;
   }
   public static void searchPair(int[] arr, int targetSum, int first, int second, List<List<Integer>> quadruplets){
      int right = arr.length-1;
      int sum =0;
      int left = second + 1;

      while (left < right){
         sum = arr[first] + arr[second]+ arr[left] + arr[right];

         if( sum == targetSum){
            //quadruplets.add(Arrays.asList(new Integet [] {arr[first],arr[second],arr[left], arr[right] }));
            quadruplets.add(Arrays.asList(arr[first],arr[second],arr[left], arr[right]));

            left ++; right --;
            while(arr[left] == arr[left-1] && left < right) left++;
            while(arr[right] == arr[right+1] && left < right) right--;

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