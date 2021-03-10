import java.util.*;

class MinimumWindowSubstring {
   public static String findSubstring(String str, String pattern) {
      // TODO: Write your code here
      int winStart=0;
      int winEnd=0;
      int matched =0;
      int minLen = str.length();
      int minStart =0;
      boolean found = false;

      HashMap<Character, Integer> charFreq = new HashMap<>();

      for ( winEnd = 0; winEnd < pattern.length(); winEnd++ ){
         char rightChar = pattern.charAt(winEnd);
         charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);
      }

      for( winEnd=0; winEnd < str.length(); winEnd++ ){
         char rightChar = str.charAt(winEnd);

         if (charFreq.containsKey(rightChar)){
            charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) - 1);
            if(charFreq.get(rightChar) == 0 )
               matched ++;
         }


         while(matched == charFreq.size()) {
            char leftChar = str.charAt(winStart);
            if (charFreq.containsKey(leftChar)) {
               if (charFreq.get(leftChar) == 0) {
                  matched--;
                  if(winEnd - winStart + 1 < minLen) {
                     minLen = winEnd - winStart + 1;
                     minStart = winStart;
                     found  = true;
                  }
               }
               charFreq.put(leftChar, charFreq.getOrDefault(leftChar, 0) + 1);
            }
            winStart ++;
         }
      }

      return found ? str.substring(minStart, minStart + minLen) : "";

   }

   public static void main(String[] args) {
      System.out.println("smallest substring has all the characters of the pattern are \"" + MinimumWindowSubstring.findSubstring("aabdec","abc") + "\"" );

      System.out.println("smallest substring has all the characters of the pattern are \"" + MinimumWindowSubstring.findSubstring("abdbca","abc") + "\"" );

      System.out.println("smallest substring has all the characters of the pattern are \"" + MinimumWindowSubstring.findSubstring("adcad","abc") + "\"" );
   }
}
