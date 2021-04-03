import java.util.*;

class KLargestNumbers {

   public static List<Integer> findKLargestNumbers(int[] nums, int k) {
      // TODO: Write your code here
      PriorityQueue<Integer> queue = new PriorityQueue<>(10, (o1, o2) -> {return o2 - o1;});
      for(int num: nums){
         queue.add(num);
      }
      List<Integer> result = new ArrayList<>();

      for( int i = 0; i < k; i++)
         result.add(queue.poll());
      return result;
   }

   public static void main(String[] args) {
      List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
      System.out.println("Here are the top K numbers: " + result);

      result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
      System.out.println("Here are the top K numbers: " + result);
   }
}
