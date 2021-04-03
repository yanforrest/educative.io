import java.util.*;

class FrequencySort {

   public static String sortCharacterByFrequency(String str) {
      Map<Character, Integer> characterFrequencyMap = new HashMap<>();
      for( char c : str.toCharArray() ){
         characterFrequencyMap.put( c, characterFrequencyMap.getOrDefault(c, 0) + 1);
      }
      PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());

      maxHeap.addAll(characterFrequencyMap.entrySet());

      String result = "";
      while(!maxHeap.isEmpty())
      {
         Map.Entry<Character, Integer> freq =  maxHeap.poll();
         for( int i =0; i < freq.getValue(); i++)
            result += freq.getKey();
      }
      return result;
   }

   public static void main(String[] args) {
      String result = FrequencySort.sortCharacterByFrequency("Programming");
      System.out.println("Here is the given string after sorting characters by frequency: " + result);

      result = FrequencySort.sortCharacterByFrequency("abcbab");
      System.out.println("Here is the given string after sorting characters by frequency: " + result);
   }
}

