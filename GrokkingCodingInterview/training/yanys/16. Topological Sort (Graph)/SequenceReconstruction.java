import java.util.*;

class SequenceReconstruction {
   public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
      List<Integer> sortedOrder = new ArrayList<>();
      Map<Integer,Integer> inDegree  = new HashMap<>();
      Map<Integer, List<Integer>> graph = new HashMap<>();

      for(int[] seq: sequences) {
         for (int i = 0; i < seq.length; i++) {
            inDegree.putIfAbsent(seq[i], 0);
            graph.putIfAbsent(seq[i], new ArrayList<>());
         }
      }

      for(int[] seq: sequences){
         for( int j = 0; j < seq.length-1; j++) {
            Integer parent = seq[j];
            Integer child = seq[j+1];
            inDegree.put(child, inDegree.get(child) + 1);
            graph.get(parent).add(child);
         }
      }

      if(inDegree.size() != originalSeq.length){
         return false;
      }

      Queue<Integer> sources = new LinkedList<>();
      for(Integer node : inDegree.keySet() ){
         if (inDegree.get(node) == 0 ) sources.add(node);
      }


      while(!sources.isEmpty()){
         if( sortedOrder.size()  >= originalSeq.length || originalSeq[sortedOrder.size() ] != sources.peek() || sources.size() > 1 ) {
            //System.out.println("no match, or no unique");
            return false;
         }
         Integer source = sources.poll();
         sortedOrder.add(source);
         for(Integer child : graph.get(source)){
            inDegree.put(child, inDegree.get(child)-1);
            if(inDegree.get(child) == 0){
               sources.add(child);
            }
         }
      }

      return true;
   }

   public static void main(String[] args) {
      boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
         new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
      System.out.println("Can we uniquely construct the sequence: " + result);

      result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
         new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
      System.out.println("Can we uniquely construct the sequence: " + result);

      result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
         new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
      System.out.println("Can we uniquely construct the sequence: " + result);
   }
}