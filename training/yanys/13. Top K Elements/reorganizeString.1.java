import java.util.*;

class RearrangeStringKDistanceApart {

   public static String reorganizeString(String str, int k) {
      Map<Character, Integer> charFreqMap = new HashMap<>();

      for(int i =0; i < str.length(); i++){
         Character cur = str.charAt(i);
         charFreqMap.put(cur, charFreqMap.getOrDefault(cur, 0) +1);
      }
      PriorityQueue<Map.Entry<Character,Integer>> minHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
      minHeap.addAll(charFreqMap.entrySet());

      String result = new String();
      Map.Entry<Character,Integer> [] mapEntries = new Map.Entry[k];
      int cur =0;

      while(!minHeap.isEmpty() || mapEntries[cur] != null){
         if(mapEntries[cur]!=null){
            minHeap.add(mapEntries[cur]);
         }
         mapEntries[cur]=minHeap.poll();
         result += mapEntries[cur].getKey();
         int value;
         if( ( value = mapEntries[cur].getValue()) > 1)
            mapEntries[cur].setValue(value-1);
         else
            mapEntries[cur]=null;
         cur = (cur+1)%k;
      }

      if(result.length() < str.length()) return "";

      return result;
   }

   public static void main(String[] args) {
      System.out.println("Reorganized string: " +
         RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
      System.out.println("Reorganized string: " +
         RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
      System.out.println("Reorganized string: " +
         RearrangeStringKDistanceApart.reorganizeString("aab", 2));
      System.out.println("Reorganized string: " +
         RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
   }
}