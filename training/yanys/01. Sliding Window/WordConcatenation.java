import java.util.*;

class WordConcatenation {
   public static List<Integer> findWordConcatenation(String str, String[] words) {
      List<Integer> resultIndices = new ArrayList<Integer>();
      // TODO: Write your code here

      HashMap<String, Integer> wordFreq = new HashMap<>();

      for (int wordEnd =0; wordEnd < words.length; wordEnd++){
         String leftWord = words[wordEnd];
         wordFreq.put(leftWord,wordFreq.getOrDefault(leftWord,0) + 1 );
      }

      int winStart = 0;
      int wordLen = words[0].length();
      int wordCount = words.length;
      int wordStart = 0;
      int matched = 0;

      for(winStart=0; winStart <= str.length() - wordCount * wordLen; winStart++){
         HashMap<String, Integer>  tempWordFreq = new HashMap<>(wordFreq);
         matched = 0;
         for(wordStart = winStart; wordStart < winStart + wordCount * wordLen; wordStart+= wordLen ){
            String word = str.substring(wordStart,wordStart+wordLen);
            if(tempWordFreq.containsKey(word) == false)
              break;
            if(tempWordFreq.get(word)==0)
               break;
            tempWordFreq.put(word, tempWordFreq.get(word)-1);
            if(tempWordFreq.get(word)>=0)
               matched++;
         }
         if(matched == wordCount)
            resultIndices.add(winStart);

      }

      return resultIndices;
   }

   public static void main(String[] args) {
      List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
      System.out.println(result);
      result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
      System.out.println(result);
   }

}