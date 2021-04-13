import java.util.*;

class Node
{
   int row;
   int col;
   Node(int rowIndex, int colIndex){
      this.row = rowIndex;
      this.col = colIndex;
   }
}
class KthSmallestInSortedMatrix {

   public static int findKthSmallest(int[][] matrix, int k) {
      PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) ->
         matrix[o1.row][o1.col]-matrix[o2.row][o2.col]);

      for(int i = 0; i < matrix.length ; i++)
         minHeap.add(new Node(i,0));

      int i = 0;
      int result = 0;
      while(!minHeap.isEmpty()){
         Node cur = minHeap.poll();
         if (++i == k) {
            result = matrix[cur.row][cur.col];
            break;
         }
         cur.col++;
         if(cur.col < matrix[cur.row].length)
            minHeap.add(cur);
      }

      return result;
   }

   public static void main(String[] args) {
      int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
      int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
      System.out.print("Kth smallest number is: " + result);
   }
}
