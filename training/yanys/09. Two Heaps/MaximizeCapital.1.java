import java.util.*;

class MaximizeCapital {
   public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      int currentCapital = initialCapital;
      int projectCapital = 0;

      // TODO: Write your code here
      for(int i = 0; i < capital.length; i++){
         minHeap.add(capital[i]);
      }

      while(!minHeap.isEmpty()){
         if( minHeap.peek() > currentCapital) {
            currentCapital = currentCapital + maxHeap.peek();
         }else {
            maxHeap.add(profits[minHeap.poll()]);
         }
      }

      currentCapital = currentCapital + maxHeap.peek();
      return currentCapital;
   }

   public static void main(String[] args) {
      int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
      System.out.println("Maximum capital: " + result);
      result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
      System.out.println("Maximum capital: " + result);
   }
}