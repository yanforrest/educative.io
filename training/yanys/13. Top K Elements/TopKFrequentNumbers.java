import java.util.*;

class TopKFrequentNumbers {

   public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
      // find the frequency of each number
     Map<Integer, Integer> numFrequencyMap = new HashMap<>();

     for( int num : nums ){
        numFrequencyMap.put( num, numFrequencyMap.getOrDefault( num,0)+1);
     }

     PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) ->o1.getValue()- o2.getValue());

     for (Map.Entry<Integer,Integer> num : numFrequencyMap.entrySet()){
        queue.add(num);
        if(queue.size() > k){
           queue.poll();
        }
     }
     List<Integer> topsKNumbers = new LinkedList<>();
     while(!queue.isEmpty()){
        topsKNumbers.add(queue.poll().getKey());
     }
     return topsKNumbers;
   }

   public static void main(String[] args) {
      List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
      System.out.println("Here are the K frequent numbers: " + result);

      result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
      System.out.println("Here are the K frequent numbers: " + result);
   }
}
