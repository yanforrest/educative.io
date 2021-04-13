import java.util.*;

class GraphVertex {
   Integer name;
   Integer inDegrees;
   List<Integer> adjacencyList;
   GraphVertex(Integer name, Integer inDegrees, List<Integer>adjacencyList){
      this.name = name;
      this.inDegrees = inDegrees;
      this.adjacencyList = adjacencyList;
   }
}
class TopologicalSort {
   public static List<Integer> sort(int vertices, int[][] edges) {
      List<Integer> sortedOrder = new ArrayList<>();

      Map<Integer, GraphVertex> graphMap= new HashMap<>();

      for(int i=0; i < vertices; i++){
         graphMap.put(i, new GraphVertex(i, 0, new LinkedList<>()));
      }

      for(int i = 0; i < edges.length; i++){
            GraphVertex cur = graphMap.get(edges[i][0]);
            cur.adjacencyList.add(edges[i][1]);
            graphMap.get(edges[i][1]).inDegrees++;
      }

      Queue<GraphVertex> sourceQueue = new LinkedList<>();

      while(!graphMap.isEmpty()) {
         for (int i = 0; i < vertices; i++) {
            if( graphMap.containsKey(i)) {
               GraphVertex cur = graphMap.get(i);
               if (cur.inDegrees == 0) {    // first: get all the source vertex,
                  graphMap.remove(i);       // second: remove source vertex from the HashMap,
                  sourceQueue.add(cur);     // put the source vertex to queue.
                  for (int j : cur.adjacencyList) {  // decrement the in-degree of each child
                     graphMap.get(j).inDegrees--;
                  }
               }
            }
         }
      }

      while( !sourceQueue.isEmpty())
         sortedOrder.add(sourceQueue.poll().name);

      return sortedOrder;
   }

   public static void main(String[] args) {
      List<Integer> result = TopologicalSort.sort(4,
         new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
      System.out.println(result);

      result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
         new int[] { 2, 1 }, new int[] { 3, 1 } });
      System.out.println(result);

      result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
         new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
      System.out.println(result);
   }
}