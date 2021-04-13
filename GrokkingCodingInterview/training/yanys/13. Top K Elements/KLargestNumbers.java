import java.util.*;

class KLargestNumbers {

   public static List<Integer> findKLargestNumbers(int[] nums, int k) {
      // TODO: Write your code here
      PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> {return o1 - o2;});
      for(int i=0; i < k; i++ ){
         minHeap.add(nums[i]);
      }
      List<Integer> result = new ArrayList<>();

      for( int i = k; i < nums.length; i++) {
         minHeap.add(nums[i]);
         minHeap.poll();
      }

      return new ArrayList<>(minHeap);
   }

   public static void main(String[] args) {
      List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
      System.out.println("Here are the top K numbers: " + result);

      result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
      System.out.println("Here are the top K numbers: " + result);
   }
}
