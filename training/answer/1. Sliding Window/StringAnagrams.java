import java.util.*;

class StringAnagrams {
   public static List<Integer> findStringAnagrams(String str, String pattern) {
      List<Integer> resultIndices = new ArrayList<Integer>();
      // TODO: Write your code here

      int winStart =0;
      int winEnd = 0;
      int matches=0;

      HashMap<Character, Integer> charFreq = new HashMap<>();

      for(winEnd = 0; winEnd < pattern.length(); winEnd++){
         char rightChar = pattern.charAt(winEnd);
         charFreq.put(rightChar,charFreq.getOrDefault(rightChar, 0) + 1);
      }

      for(winEnd = 0; winEnd < str.length(); winEnd++){
         char rightChar = str.charAt(winEnd);
         if(charFreq.containsKey(rightChar)) {

            charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) - 1);
            if (charFreq.get(rightChar)==0)
               matches++;
         }
         if ( matches == charFreq.size() )
               resultIndices.add(winStart);

         if(winEnd >= pattern.length() - 1 ){
            char leftChar = str.charAt(winStart);
            if(charFreq.containsKey(leftChar)) {
               if (charFreq.get(leftChar)==0)
                  matches--;
               charFreq.put(leftChar, charFreq.getOrDefault(leftChar, 0) + 1);
            }
            winStart++;
         }
      }
      return resultIndices;
   }

   public static void main(String[] args) {
      System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
      System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
   }
}