import java.util.*;

class RearrangeStringKDistanceApart {

   public static String reorganizeString(String str, int k) {
      Map<Character, Integer> charFreqMap = new HashMap<>();

      for(int i =0; i < str.length(); i++){
         Character cur = str.charAt(i);
         charFreqMap.put(cur, charFreqMap.getOrDefault(cur, 0) +1);
      }
      PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
      maxHeap.addAll(charFreqMap.entrySet());

      String result = new String();
      Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

      while(!maxHeap.isEmpty()){
         Map.Entry<Character, Integer> curEntity = maxHeap.poll();
         result += curEntity.getKey();
         curEntity.setValue(curEntity.getValue()-1);
         queue.add(curEntity);

         if(queue.size()==k){
            Map.Entry<Character,Integer> entry = queue.poll();
            if(entry.getValue() > 0)
               maxHeap.add(entry);
         }
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