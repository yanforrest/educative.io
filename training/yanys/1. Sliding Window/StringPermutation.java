import java.util.*;

public class StringPermutation {
   public static boolean findPermutationString(String str, String pattern){

      int winStart = 0;
      int winEnd   = 0;
      int patternLen = pattern.length();
      char rightChar;
      char leftChar;
      int matched = 0;

      HashMap<Character, Integer> charFreq = new HashMap<>();

      for(winEnd=0; winEnd < patternLen; winEnd++){
         rightChar = pattern.charAt(winEnd);
         charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);
      }

      for(winEnd=0; winEnd < str.length(); winEnd++){
         rightChar = str.charAt(winEnd);
         if(charFreq.containsKey(rightChar)) {
            charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) - 1);
            if (charFreq.get(rightChar) == 0) matched++;
         }

         if (matched == charFreq.size()) return true;


         if( winEnd >= patternLen - 1){
            leftChar = str.charAt(winStart);
            if(charFreq.containsKey(leftChar)) {
               if (charFreq.get(leftChar) == 0) matched--;
               charFreq.put(leftChar, charFreq.getOrDefault(leftChar, 0) + 1);
            }
            winStart ++;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      System.out.println(StringPermutation.findPermutationString("oidbcaf", "abc"));
      System.out.println(StringPermutation.findPermutationString("odicf", "dc"));
      System.out.println(StringPermutation.findPermutationString("bcdxabcdy", "bcdyabcdx"));
      System.out.println(StringPermutation.findPermutationString("aaacb", "abc"));
   }
}
