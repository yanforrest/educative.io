import java.util.*;

class SubarrayProductLessThanK {

   public static List<List<Integer>> findSubarrays(int[] arr, int target) {
      List<List<Integer>> subarrays = new ArrayList<>();
      // TODO: Write your code here
      int left=0, right = 0;
      int prod = 1;
      for(right =0; right < arr.length; right++) {
         prod *= arr[right];
         while (prod >= target)
               prod /= arr[left++];

         // form the integer windows which product is less than target.
         List<Integer> integerList = new ArrayList();
         for(int i = right; i >= left ; i --){
            integerList.add(0, arr[i]);
            List<Integer> value = new ArrayList<>(integerList);
            subarrays.add(value);
         }
      }

      return subarrays;
   }

   public static void main(String[] args) {
      System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
      System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
   }
}
