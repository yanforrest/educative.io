import java.util.*;

class TopologicalSort {
   public static List<Integer> sort(int vertices, int[][] edges) {
      List<Integer> sortedOrder = new ArrayList<>();


      Map<Integer, Integer> inDegree = new HashMap<>();
      Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

      for (int i = 0; i < vertices; i++) {
         inDegree.put(i, 0);
         adjacencyList.put(i, new LinkedList<>());
      }

      for (int i = 0; i < edges.length; i++) {
         adjacencyList.get(edges[i][0]).add(edges[i][1]);
         inDegree.put(edges[i][1], inDegree.get(edges[i][1]) + 1);
      }

      Queue<Integer> sourceQueue = new LinkedList<>();

      for (int i = 0; i < vertices; i++) {
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

      if (sortedOrder.size() != vertices) // topological sort is not possible as the graph has a cycle
         return new ArrayList<>();

      return sortedOrder;
   }

   public static void main(String[] args) {
     List<Integer> result = TopologicalSort.sort(4,
         new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
      System.out.println(result);

      result = TopologicalSort.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
         new int[]{2, 1}, new int[]{3, 1}});
      System.out.println(result);

      result = TopologicalSort.sort(7, new int[][]{new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3},
         new int[]{5, 4}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}});
      System.out.println(result);

   }
}
