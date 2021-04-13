import java.util.*;

class FrequencySort {

   public static String sortCharacterByFrequency(String str) {
      Map<Character, Integer> map = new HashMap<>();
      for( int i = 0; i < str.length(); i++ ){
         map.put( str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
      }
      PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());

      for(Map.Entry<Character,Integer> entry : map.entrySet()){
         maxHeap.add(entry);
      }
      
      String result = "";
      for(Map.Entry<Character,Integer> freq: maxHeap){
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

