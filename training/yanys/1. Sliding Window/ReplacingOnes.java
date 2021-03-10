import java.util.HashMap;

class ReplacingOnes {
   /*
   public static int findLength(int[] arr, int k) {
      // TODO: Write your code here
      int winStart = 0;
      int winEnd = 0;
      int maxRepeatedLength = 0;
      int maxLength = 0;

      HashMap<Integer, Integer> intFreq = new HashMap<>();

      for( winEnd = 0; winEnd < arr.length; winEnd++){
         int rightInt = arr[winEnd];
         intFreq.put(rightInt, intFreq.getOrDefault(rightInt, 0) + 1);

         maxRepeatedLength = Math.max(maxRepeatedLength, intFreq.get(rightInt));

         if( winEnd - winStart + 1 - maxRepeatedLength > k ){
            int leftInt = arr[winStart];
            intFreq.put(leftInt, intFreq.getOrDefault(leftInt, 0) - 1);
            intFreq.remove(leftInt,0);
            winStart ++ ;
         }

         maxLength = Math.max(maxLength, winEnd - winStart + 1);

      }
      return maxLength;
   }
   */

   public static int findLength(int[] arr, int k) {
      // TODO: Write your code here
      int winStart = 0;
      int winEnd = 0;
      int maxRepeatedLength = 0;
      int maxLength = 0;

      int int1Freq = 0;

      for( winEnd = 0; winEnd < arr.length; winEnd++){
         int rightInt = arr[winEnd];
         if( rightInt == 1 ) int1Freq ++;

         maxRepeatedLength = Math.max(maxRepeatedLength, int1Freq);

         if( winEnd - winStart + 1 - maxRepeatedLength > k ){
            int leftInt = arr[winStart];
            if( leftInt == 1 ) int1Freq --;
            winStart ++ ;
         }

         maxLength = Math.max(maxLength, winEnd - winStart + 1);

      }
      return maxLength;
   }

   public static void main(String[] args) {
      System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
      System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
   }

}