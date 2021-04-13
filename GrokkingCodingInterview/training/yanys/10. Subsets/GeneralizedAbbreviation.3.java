import com.sun.deploy.security.SelectableSecurityManager;

import java.util.*;

class AbbreviatedWord{
   StringBuilder str;
   int start;
   int count;
   public AbbreviatedWord(StringBuilder str, int start, int count){
      this.str = str;
      this.start = start;
      this.count = count;
   }
}

class GeneralizedAbbreviation {

   public static List<String> generateGeneralizedAbbreviation(String word) {
      List<String> result = new ArrayList<String>();
      // TODO: Write your code here
      Queue<AbbreviatedWord> queue = new LinkedList<>();
      queue.add(new AbbreviatedWord(new StringBuilder(), 0,0));

      for(int i=0; i < word.length(); i++){
         int n = queue.size();
         for(int j=0; j< n; j++){
            AbbreviatedWord cur = queue.poll();
            if( i == word.length()-1){
               result.add(cur.str.toString()+(cur.count+1));
               if(cur.count!=0)
                  result.add(cur.str.toString() + cur.count+ word.charAt(i));
               else
                  result.add(cur.str.toString() + word.charAt(i));
            }else {
               /* add abbreviate " " */
               queue.add( new AbbreviatedWord(new StringBuilder(cur.str), cur.start, cur.count + 1));
               /* add next character */
               AbbreviatedWord cur2;
               if(cur.count!=0)
                  queue.add( new AbbreviatedWord(new StringBuilder(cur.str.toString() + cur.count + word.charAt(i)), cur.start, 0));
               else
                  queue.add( new AbbreviatedWord(new StringBuilder(cur.str.toString() + word.charAt(i)), cur.start, 0));
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
      System.out.println("Generalized abbreviation are: " + result);

      result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
      System.out.println("Generalized abbreviation are: " + result);
   }
}