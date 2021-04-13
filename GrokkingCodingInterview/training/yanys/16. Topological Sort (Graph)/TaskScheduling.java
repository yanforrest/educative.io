import java.util.*;

class TaskScheduling {
   public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
      List<Integer> sortedOrder = new ArrayList<>();


      Map<Integer, Integer> inDegree = new HashMap<>();
      Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

      for (int i = 0; i < tasks; i++) {
         inDegree.put(i, 0);
         adjacencyList.put(i, new LinkedList<>());
      }

      for (int i = 0; i < prerequisites.length; i++) {
         adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
         inDegree.put(prerequisites[i][1], inDegree.get(prerequisites[i][1]) + 1);
      }

      Queue<Integer> sourceQueue = new LinkedList<>();
      for (int i = 0; i < tasks; i++) {
         if (inDegree.get(i) == 0)
            sourceQueue.add(i);
      }

      while (!sourceQueue.isEmpty()) {
         Integer cur = sourceQueue.poll();
         sortedOrder.add(cur);
         for (int child : adjacencyList.get(cur)) {
            inDegree.put(child, inDegree.get(child) - 1);
            if (inDegree.get(child) == 0)
               sourceQueue.add(child);
         }
      }

      return sortedOrder.size() == tasks;// topological sort is not possible as the graph has a cycle

   }

   public static void main(String[] args) {

      boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
      System.out.println("Tasks execution possible: " + result);

      result = TaskScheduling.isSchedulingPossible(3,
         new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
      System.out.println("Tasks execution possible: " + result);

      result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
         new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
      System.out.println("Tasks execution possible: " + result);
   }
}
