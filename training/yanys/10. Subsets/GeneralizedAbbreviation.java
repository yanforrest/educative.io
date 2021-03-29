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

      while(!queue.isEmpty()){
         AbbreviatedWord cur = queue.poll();

         if ( cur.start == word.length() ){
            if(cur.count!=0)
               result.add(cur.str.toString() + cur.count);
            else
               result.add(cur.str.toString());
         }else {
            /* add abbreviate " " */
            queue.add( new AbbreviatedWord(new StringBuilder(cur.str), cur.start+1, cur.count + 1));
            /* add next character */
            AbbreviatedWord cur2;
            if(cur.count!=0)
               cur.str.append(cur.count);

            queue.add( new AbbreviatedWord(new StringBuilder(cur.str.toString() + word.charAt(cur.start)), cur.start+1, 0));
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