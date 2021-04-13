import java.util.*;

class CountUniqueTrees {
   Map<Integer, Integer>  map = new HashMap<>();

   public int countTrees(int n ){
      if (map.containsKey(n)) {
         return map.get(n);
      }

      int result =0;
      if( n < 1) return 1;

      for(int i= 1; i <= n; i++ ){
         int left = countTrees( i-1);
         int right = countTrees(n-i);
         result += left * right;
      }

      map.put(n, result);

      return result;
   }

   public static void main(String[] args) {
      CountUniqueTrees ct = new CountUniqueTrees();
      int count = ct.countTrees(2);
      System.out.print("Total trees: " + count);
   }
}