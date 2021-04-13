import java.util.*;

class Interval {
   int start;
   int end;

   public Interval(int start, int end) {
      this.start = start;
      this.end = end;
   }
};

class MergeIntervals {

   public static List<Interval> merge(List<Interval> intervals) {
      List<Interval> mergedIntervals = new LinkedList<Interval>();
      List<Interval> sourceIntervals = new ArrayList<>(intervals);

      // TODO: Write your code here
      while(!sourceIntervals.isEmpty()){
         Interval merge = sourceIntervals.get(0);
         sourceIntervals.remove(0);

         boolean intersected = false;
         do {
            intersected = false;
            for (int i = sourceIntervals.size() - 1; i >= 0; i--) {
               Interval cur = sourceIntervals.get(i);
               if (intervalIntersect(merge, cur)) {
                  merge = intervalMerge(merge, cur);
                  sourceIntervals.remove(i);
                  intersected = true;
               }
            }
         }while(intersected == true);
         mergedIntervals.add(merge);
      }
      return mergedIntervals;
   }

   public static boolean intervalIntersect(Interval a, Interval b){
      if(a.start > b.end  || b.start > a.end) {
         return false;
      } else {
         return true;
      }
   }
   public static Interval intervalMerge(Interval a, Interval b)
   {


      if(a.start > b.end  || b.start > a.end) {
         return null;
      } else {
         return  new Interval(
            Math.min(a.start, b.start),
            Math.max(a.end, b.end)
         );
      }


   }

   public static void main(String[] args) {
      List<Interval> input = new ArrayList<Interval>();
      input.add(new Interval(1, 4));
      input.add(new Interval(2, 5));
      input.add(new Interval(7, 9));
      System.out.print("Merged intervals: ");
      for (Interval interval : MergeIntervals.merge(input))
         System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();

      input = new ArrayList<Interval>();
      input.add(new Interval(6, 7));
      input.add(new Interval(2, 4));
      input.add(new Interval(5, 9));
      System.out.print("Merged intervals: ");
      for (Interval interval : MergeIntervals.merge(input))
         System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();

      input = new ArrayList<Interval>();
      input.add(new Interval(1, 4));
      input.add(new Interval(2, 6));
      input.add(new Interval(3, 5));
      System.out.print("Merged intervals: ");
      for (Interval interval : MergeIntervals.merge(input))
         System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();
   }
}