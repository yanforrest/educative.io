import java.util.*;

class SlidingWindowMedian {

   PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()) ;
   PriorityQueue<Integer> minHeap = new PriorityQueue<>();

   public double[] findSlidingWindowMedian(int[] nums, int k) {
      double[] result = new double[nums.length - k + 1];
      // TODO: Write your code here
      for( int i = 0 ; i< nums.length; i++){
         if(!maxHeap.isEmpty() && nums[i] < maxHeap.peek()) maxHeap.add(nums[i]);
         else if(!minHeap.isEmpty() && nums[i] > minHeap.peek() ) minHeap.add(nums[i]);
         else maxHeap.add(nums[i]);
         rebalance();

         if(i+1-k>=0){
            if(minHeap.size() != maxHeap.size()) result[i+1-k] = maxHeap.peek();
            else  result[i+1-k] = (minHeap.peek() + maxHeap.peek())/2.0;


            if(maxHeap.contains(nums[i+1-k])) maxHeap.remove(nums[i+1-k]);
            else minHeap.remove(nums[i+1-k]);

            rebalance();
         }
      }


      return result;
   }
   private void rebalance()
   {
      if ( maxHeap.size() > this.minHeap.size() + 1){
         minHeap.add(maxHeap.poll());
      }if( maxHeap.size() < minHeap.size()){
         maxHeap.add(minHeap.poll());
      }
   }

   public static void main(String[] args) {
      SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
      double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
      System.out.print("Sliding window medians are: ");
      for (double num : result)
         System.out.print(num + " ");
      System.out.println();

      slidingWindowMedian = new SlidingWindowMedian();
      result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
      System.out.print("Sliding window medians are: ");
      for (double num : result)
         System.out.print(num + " ");
   }

}