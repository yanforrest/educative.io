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

      Collections.sort(intervals, (o1, o2)-> {
            if (o1.start > o2.start) return 1;
            else if (o1.start < o2.start) return -1;
            else return 0;
         });

      //Collections.sort(intervals, (a,b)->Integer.compare(a.start, b.start));

      List<Interval> mergedIntervals = new LinkedList<>();
      Iterator<Interval> intervalItr = intervals.listIterator();
      Interval next = null;
      int start=0, end=0;
      if(intervalItr.hasNext()) {
         next = intervalItr.next();
         start = next.start;
         end = next.end;
      }else {
         return null;
      }

      while(intervalItr.hasNext()){
         next = intervalItr.next();
         if ( next.start <= end ){
            end = Math.max(end, next.end);
         } else {
            mergedIntervals.add(new Interval(start,end));
            start = next.start; end = next.end;
         }
      }
      mergedIntervals.add(new Interval(start,end));
      return mergedIntervals;
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