import java.util.*;

class RearrangeString {

   public static String rearrangeString(String str) {
      // TODO: Write your code here
      Map<Character,Integer> charFreqMap = new HashMap<>();

      for(int i = 0; i < str.length(); i++){
         charFreqMap.put( str.charAt(i), charFreqMap.getOrDefault(str.charAt(i), 0) + 1 );
      }
      PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
      
      maxHeap.addAll(charFreqMap.entrySet());

      String result= new String();
      Map.Entry<Character,Integer>  cur=null, prev=null;

      while(!maxHeap.isEmpty()){
         prev = cur;
         cur = maxHeap.poll();
         if(prev!=null && prev.getValue() > 0 )
            maxHeap.add(prev);
         result += cur.getKey();
         cur.setValue(cur.getValue() - 1);
      }
      if(cur.getValue()!=0) return "";

      return result;
   }

   public static void main(String[] args) {
      System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
      System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
      System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
   }
}