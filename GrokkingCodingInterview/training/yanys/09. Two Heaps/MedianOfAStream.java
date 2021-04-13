import java.util.*;

class MedianOfAStream {

   PriorityQueue<Integer> maxHeap;
   PriorityQueue<Integer> minHeap;
   public void insertNum(int num) {
      // TODO: Write your code here

      if(maxHeap.isEmpty() || num < maxHeap.peek()) {
         maxHeap.add(num);
      } else
         minHeap.add(num);

      //balance maxHeap and minHeap
      if (maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
      if (maxHeap.size() > minHeap.size()+1) minHeap.add(maxHeap.poll());

   }

   public double findMedian() {
      // TODO: Write your code here
      if(maxHeap.size() == minHeap.size()){
         return (minHeap.peek()+maxHeap.peek())/2.0;
      }else
         return maxHeap.peek();
   }

   public MedianOfAStream() {
      maxHeap = new PriorityQueue<Integer>((a, b)-> - (a-b));
      minHeap = new PriorityQueue<Integer>((a, b)->   (a-b));
   }

   public static void main(String[] args) {
      MedianOfAStream medianOfAStream = new MedianOfAStream();
      medianOfAStream.insertNum(3);
      medianOfAStream.insertNum(1);
      System.out.println("The median is: " + medianOfAStream.findMedian());
      medianOfAStream.insertNum(5);
      System.out.println("The median is: " + medianOfAStream.findMedian());
      medianOfAStream.insertNum(4);
      System.out.println("The median is: " + medianOfAStream.findMedian());
   }
}
