import java.util.*;

class Interval{
   int start;
   int end;
   public Interval(int start , int end){
      this.start = start;
      this.end = end;
   }
}

class CountUniqueTrees {
   Map<Interval, Integer>  map = new HashMap<>();

   public int countTrees(int n) {
      return countTrees(new Interval(1,n));
   }
   public int countTrees(Interval in){
      if (map.containsKey(in)) {
         return map.get(in);
      }

      int result =0;
      if( in.start > in.end ) return 1;

      for(int i= in.start; i <= in.end; i++ ){
         int left = countTrees( new Interval(in.start, i-1));
         int right = countTrees(new Interval(i+1, in.end));
         result += left * right;
      }

      map.put(in, result);

      return result;
   }

   public static void main(String[] args) {
      CountUniqueTrees ct = new CountUniqueTrees();
      int count = ct.countTrees(3);
      System.out.print("Total trees: " + count);
   }
}