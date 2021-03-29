import java.util.*;

class GenerateParentheses {

   public static List<String> generateValidParentheses(int num) {
      List<String> result = new ArrayList<String>();
      List<Integer> left = new ArrayList<>();
      List<Integer> right = new ArrayList<>();

      result.add(new String()); left.add(0); right.add(0);

      int j = 0;
      while( j++ != num * 2 ){
         int setSize = result.size();
         for(int i=0; i< setSize; i++) {
            String cur = result.remove(0);
            int l =left.remove(0), r = right.remove(0);
            if (l < num){
               result.add(cur+"("); left.add(l+1); right.add(r);
            }
            if (r < l) {
               result.add(cur+")"); left.add(  l); right.add(r+1);
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      List<String> result = GenerateParentheses.generateValidParentheses(2);
      System.out.println("All combinations of balanced parentheses are: " + result);

      result = GenerateParentheses.generateValidParentheses(3);
      System.out.println("All combinations of balanced parentheses are: " + result);
   }
}
