import java.util.*;

class LetterCaseStringPermutation {

   public static List<String> findLetterCaseStringPermutations(String str) {
      List<String> permutations = new ArrayList<>();

      Queue<List<Character>> queue = new LinkedList<>();

      queue.add(new ArrayList<>());

      for(int i=0; i < str.length(); i++ ){
         Character c = str.charAt(i);

         if(Character.isLetter(c)){
            int n = queue.size();
            for( int j=0; j < n ; j++) {
               List<Character> cur = queue.poll();
               List<Character> cur1 = new ArrayList<>(cur);
               List<Character> cur2 = new ArrayList<>(cur);
               cur1.add(Character.toLowerCase(c));
               cur2.add(Character.toUpperCase(c));
               queue.offer(cur1);
               queue.offer(cur2);
            }
         }else {
            int n = queue.size();
            for( int j=0; j < n ; j++) {
               List<Character> cur = queue.poll();
               cur.add(c);
               queue.offer(cur);
            }
         }
      }

      while(!queue.isEmpty()){
         permutations.add(queue.poll().toString());
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
