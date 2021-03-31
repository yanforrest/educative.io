import java.util.*;

class MaxFruitCountOf2Types {
   public static int findLength(char[] arr) {
      // TODO: Write your code here
      int winStart =0;
      int winEnd = 0;
      int maxLen = 0;

      HashMap<Character, Integer> charaterFreq = new HashMap<>();

      for (winEnd = 0; winEnd < arr.length; winEnd ++){
         char rightChar = arr[winEnd];

         charaterFreq.put(rightChar,charaterFreq.getOrDefault(rightChar,0)+1);

         while( charaterFreq.size() > 2 ){
            char leftChar = arr[winStart];
            charaterFreq.put(leftChar, charaterFreq.getOrDefault(leftChar,0)-1);
            charaterFreq.remove(leftChar, 0);
            winStart ++ ;
         }

         maxLen = Math.max(maxLen, winEnd - winStart + 1 );
      }

      return maxLen;
   }
   public static void main(String[] args) {
      System.out.println("Maximum number of fruits: " +
         MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
      System.out.println("Maximum number of fruits: " +
         MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
   }
}