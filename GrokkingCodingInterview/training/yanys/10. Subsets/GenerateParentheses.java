import java.util.*;
class ParenthesesString{
   String str;
   int    openCount;
   int    closeCount;
   public ParenthesesString( String s, int openCount, int closeCount){
      this.str = s;
      this.openCount = openCount;
      this.closeCount = closeCount;
   }
}

class GenerateParentheses {

   public static List<String> generateValidParentheses(int num) {
      List<String> result = new ArrayList<String>();

      Queue<ParenthesesString> queue = new LinkedList<>();

      queue.add(new ParenthesesString("", 0, 0));
      int j = 0;
      while( !queue.isEmpty() ){
            ParenthesesString cur = queue.poll();
            if(cur.closeCount == num && cur.openCount == num ){
               result.add(cur.str);
            } else {
               if (cur.openCount < num) {
                  queue.add(new ParenthesesString(cur.str + "(", cur.openCount + 1, cur.closeCount));
               }
               if (cur.closeCount < cur.openCount) {
                  queue.add(new ParenthesesString(cur.str + ")", cur.openCount, cur.closeCount + 1));
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
