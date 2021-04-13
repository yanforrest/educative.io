import java.util.*;

class TaskSchedulingOrder {
   public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
      List<Integer> sortedOrder = new ArrayList<>();

      Map<Integer,Integer> inDegree = new HashMap<>();
      Map<Integer, List<Integer>> graph = new HashMap<>();

      for(int i =0; i < tasks; i++){
         inDegree.put(i, 0);
         graph.put(i, new LinkedList<>());
      }

      for( int[] edge : prerequisites ){
         inDegree.put(edge[1], inDegree.get(edge[1]) + 1 );
         graph.get(edge[0]).add(edge[1]);
      }

      Queue<Integer> queue = new LinkedList<>();

      for( Map.Entry<Integer, Integer> entry :  inDegree.entrySet() ){
         if(entry.getValue() == 0) queue.add(entry.getKey());
      }

      while(!queue.isEmpty()){
         Integer source = queue.poll();
         sortedOrder.add(source);
         for( Integer child : graph.get(source)){
            inDegree.put( child, inDegree.get(child) - 1);
            if(inDegree.get(child) == 0)
               queue.add(child);
         }
      }

      if(sortedOrder.size() != tasks) return new ArrayList<>();

      return sortedOrder;
   }

   public static void main(String[] args) {
      List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
      System.out.println(result);

      result = TaskSchedulingOrder.findOrder(3,
         new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
      System.out.println(result);

      result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
         new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
      System.out.println(result);
   }
}