import java.util.*;

class MaximumDistinctElements {

   public static int findMaximumDistinctElements(int[] nums, int k) {
      // TODO: Write your code here
      if (nums.length <= k) return 0;

      Map<Integer,Integer> elementFreqMap = new HashMap<>();

      for(int i = 0; i < nums.length; i++){
         elementFreqMap.put(nums[i], elementFreqMap.getOrDefault(nums[i],0) + 1);
      }

      PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

      for(Map.Entry<Integer,Integer> entry : elementFreqMap.entrySet()){
         minHeap.add(entry);
      }

      int distinct = 0;
      while( k > 0 && !minHeap.isEmpty() ){
         Map.Entry<Integer,Integer> entry = minHeap.peek();

         if( k >= entry.getValue() - 1) {
            k -= entry.getValue() - 1;
            entry.setValue(1);
            distinct++;
         } else {
            k = 0;
            entry.setValue( entry.getValue() - k );
         }
         minHeap.poll();

      }
      return distinct-k;
   }

   public static void main(String[] args) {
      int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
      System.out.println("Maximum distinct numbers after removing K numbers: " + result);

      result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
      System.out.println("Maximum distinct numbers after removing K numbers: " + result);

      result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
      System.out.println("Maximum distinct numbers after removing K numbers: " + result);
   }
}