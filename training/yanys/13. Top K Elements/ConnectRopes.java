import java.util.*;

class ConnectRopes {

   public static int minimumCostToConnectRopes(int[] ropeLengths) {
      // TODO: Write your code here
      PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1-o2);

      for(int i = 0 ; i < ropeLengths.length; i++ ){
         minHeap.add(ropeLengths[i]);
      }
      int cost=0;
      while(minHeap.size()>=2){
         int temp = minHeap.poll() + minHeap.poll();
         minHeap.add(temp);
         cost += temp;
      }
      return cost;
   }

   public static void main(String[] args) {
      int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
      System.out.println("Minimum cost to connect ropes: " + result);
      result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
      System.out.println("Minimum cost to connect ropes: " + result);
      result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
      System.out.println("Minimum cost to connect ropes: " + result);
   }
}