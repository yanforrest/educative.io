import java.util.*;

class NoRepeatSubstring {
   public static int findLength(String str) {
      // TODO: Write your code here
      int winStart = 0 ;
      int winEnd = 0;
      int winLen = 0;

      HashMap<Character, Integer> charFreq = new HashMap<>();

      for ( winEnd = 0; winEnd < str.length(); winEnd ++){
         char rightChar = str.charAt(winEnd);
         if(charFreq.containsKey(rightChar)){
            winStart = charFreq.getOrDefault(rightChar, 0) + 1;
         }
         charFreq.put(rightChar, winEnd);
         winLen = Math.max(winLen, winEnd - winStart + 1);
      }

      return winLen;
   }

   public static void main(String[] args) {
      System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
      System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
      System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
   }
}
