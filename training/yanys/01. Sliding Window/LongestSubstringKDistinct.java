import java.util.*;
public class LongestSubstringKDistinct {
   public static int findLength(String str, int k){
      if(str == null || str.length()==0 || str.length() < k)
         throw new IllegalArgumentException();

      int winStart = 0;
      int winEnd = 0;
      int winMax = 0;

      Map<Character, Integer> charFrequency = new HashMap<>();

      for( winEnd = 0; winEnd < str.length() ; winEnd++){
         char rightChar = str.charAt(winEnd);
         charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);
         while( charFrequency.size() > k ) {
            char leftChar = str.charAt(winStart);
            charFrequency.put(leftChar, charFrequency.getOrDefault(leftChar, 0) - 1);
            charFrequency.remove(leftChar, 0);
            winStart++;
         }
         winMax = Math.max(winMax, winEnd - winStart + 1 );

      }
      return winMax;
   }

   public static void main(String[] args) {
      int result;
      result = LongestSubstringKDistinct.findLength("araaci", 2);
      System.out.println("Longest substring length " + result);
      result = LongestSubstringKDistinct.findLength("araaci", 1);
      System.out.println("Longest substring length " + result);
      result = LongestSubstringKDistinct.findLength("cbbebi", 3);
      System.out.println("Longest substring length " + result);
   }
}
