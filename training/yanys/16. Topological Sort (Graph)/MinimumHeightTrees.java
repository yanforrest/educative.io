import java.util.*;

class MinimumHeightTrees {
   public static List<Integer> findTrees(int nodes, int[][] edges) {
      List<Integer> minHeightTrees = new ArrayList<>();


      Map<Integer, Integer> degree = new HashMap<>();
      Map<Integer, List<Integer>>  graph = new HashMap<>();
      for (int i =0; i < nodes; i++){
         degree.putIfAbsent(i, 0);
         graph.putIfAbsent(i,new ArrayList<>());
      }

      for(int[] edge : edges ){
         degree.put(edge[0], degree.get(edge[0])+1);
         degree.put(edge[1], degree.get(edge[1])+1);
         graph.get(edge[0]).add(edge[1]);
         graph.get(edge[1]).add(edge[0]);
      }


      Queue<Integer> leafs = new LinkedList<>();

      for( int i =0; i< nodes; i++){
         if(degree.get(i) == 1) {
            leafs.add(i);
         }
      }

      int totalNodes =  nodes;

      while(totalNodes > 2){
         int leavesSize = leafs.size();
         totalNodes -= leavesSize;
         for(int i =0; i< leavesSize; i++) {
            Integer leaf = leafs.poll();
            for (Integer child : graph.get(leaf)) {
               degree.put(child, degree.get(child) - 1);
               if (degree.get(child) == 1)
                  leafs.add(child);
            }
         }

      }
      minHeightTrees.addAll(leafs);
      return minHeightTrees;
   }

   public static void main(String[] args) {
      List<Integer> result = MinimumHeightTrees.findTrees(5,
         new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
      System.out.println("Roots of MHTs: " + result);

      result = MinimumHeightTrees.findTrees(4,
         new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
      System.out.println("Roots of MHTs: " + result);

      result = MinimumHeightTrees.findTrees(4,
         new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
      System.out.println("Roots of MHTs: " + result);
   }
}