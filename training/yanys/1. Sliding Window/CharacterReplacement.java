import java.util.*;

class CharacterReplacement {
   public static int findLength(String str, int k) {
      // TODO: Write your code here
      int winStart=0;
      int winEnd=0;
      int maxRepeatedLetterCount =0;
      int maxLength = 0;

      HashMap<Character, Integer> letterFrequency = new HashMap<>();

      for(winEnd = 0; winEnd < str.length(); winEnd++){
         char rightChar = str.charAt(winEnd);
         letterFrequency.put(rightChar, letterFrequency.getOrDefault(rightChar, 0) + 1);
         maxRepeatedLetterCount = Math.max(maxRepeatedLetterCount, letterFrequency.get(rightChar));

         if( winEnd - winStart + 1 - maxRepeatedLetterCount > k){
            char leftChar = str.charAt(winStart);
            letterFrequency.put(leftChar, letterFrequency.getOrDefault(leftChar, 0) - 1);
            letterFrequency.remove(leftChar, 0);
            winStart++;
         }
         maxLength =  winEnd - winStart + 1;
      }
      return maxLength;
   }

   public static void main(String[] args) {
      System.out.println(CharacterReplacement.findLength("aabccbb", 2));
      System.out.println(CharacterReplacement.findLength("abbcb", 1));
      System.out.println(CharacterReplacement.findLength("abccde", 1));
   }

}