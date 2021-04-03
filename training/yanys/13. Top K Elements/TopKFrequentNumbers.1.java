import java.util.*;
class Freq {
   Integer key;
   Integer freq;
   public Freq(int key, int freq){
      this.key = key;
      this.freq = freq;
   }
}

class TopKFrequentNumbers {

   public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
      List<Integer> topNumbers = new ArrayList<>(k);
      // TODO: Write your code here
      HashMap<Integer, Integer> hashMap = new HashMap<>();
      for ( int num : nums){
         if( hashMap.containsKey(num)) hashMap.put(num, hashMap.get(num)+1);
         else hashMap.put(num, 1);
      }
      PriorityQueue<Freq> maxHeap = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);


      for( Integer key : hashMap.keySet()){
         maxHeap.add(new Freq( key,  hashMap.get(key)));
      }
      for( int i =0; i < k; i++){
         topNumbers.add(maxHeap.poll().key);
      }
      return topNumbers;
   }

   public static void main(String[] args) {
      List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
      System.out.println("Here are the K frequent numbers: " + result);

      result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
      System.out.println("Here are the K frequent numbers: " + result);
   }
}
