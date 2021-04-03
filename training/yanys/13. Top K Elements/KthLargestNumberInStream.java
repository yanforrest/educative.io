import java.util.*;

class KthLargestNumberInStream {
   PriorityQueue<Integer> minHeap;
   public KthLargestNumberInStream(int[] nums, int k) {
      // TODO: Write your code here
      minHeap = new PriorityQueue<>((o1, o2) -> o1-o2);
      int i = 0;
      for( i = 0 ; i < nums.length; i++){
         minHeap.add(nums[i]);
         if( i >= k) minHeap.poll();
      }
   }

   public int add(int num) {
      minHeap.add(num);
      minHeap.poll();
      return minHeap.peek();
   }

   public static void main(String[] args) {
      int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
      KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
      System.out.println("4th largest number is: " + kthLargestNumber.add(6));
      System.out.println("4th largest number is: " + kthLargestNumber.add(13));
      System.out.println("4th largest number is: " + kthLargestNumber.add(4));
   }
}
