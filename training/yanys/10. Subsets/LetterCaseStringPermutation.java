import java.util.*;

class LetterCaseStringPermutation {

   public static List<String> findLetterCaseStringPermutations(String str) {
      List<String> permutations = new ArrayList<>();

      if( str == null) return permutations;

      permutations.add(str);

      for(int i=0; i< str.length(); i++){
         if(Character.isLetter(str.charAt(i))){
            int n = permutations.size();
            for(int j =0; j < n; j++){
               char[] cur = permutations.get(j).toCharArray();
               if(Character.isLowerCase(cur[i])){
                  cur[i] = Character.toUpperCase(cur[i]);
               }else{
                  cur[i] = Character.toLowerCase(cur[i]);
               }
               permutations.add(String.valueOf(cur));
            }
         }
      }

      return permutations;
   }

   public static void main(String[] args) {
      List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
      System.out.println(" String permutations are: " + result);

      result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
      System.out.println(" String permutations are: " + result);
   }
}
