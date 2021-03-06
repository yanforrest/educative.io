import java.util.*;

class Interval {
   int start;
   int end;

   public Interval(int start, int end) {
      this.start = start;
      this.end = end;
   }
};

class InsertInterval {

   public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
      if(intervals == null || intervals.isEmpty())
         return Arrays.asList(newInterval);

      List<Interval> mergedIntervals = new ArrayList<>();
      //TODO: Write your code here
      int start= newInterval.start, end = newInterval.end;
      int i = 0;

      while ( i < intervals.size() && intervals.get(i).end < start ){
         mergedIntervals.add(intervals.get(i++));
      }

      while ( i < intervals.size() && ( intervals.get(i).start <= end  &&  intervals.get(i).end >= start )){
         start = Math.min(start,intervals.get(i).start );
         end = Math.max(end,intervals.get(i).end );
         i++;
      }
      mergedIntervals.add(new Interval(start, end));

      while ( i < intervals.size() && intervals.get(i).start > end ){
         mergedIntervals.add(intervals.get(i++));
      }

      return mergedIntervals;
   }

   public static void main(String[] args) {
      List<Interval> input = new ArrayList<Interval>();
      input.add(new Interval(1, 3));
      input.add(new Interval(5, 7));
      input.add(new Interval(8, 12));
      System.out.print("Intervals after inserting the new interval: ");
      for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
         System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();

      input = new ArrayList<Interval>();
      input.add(new Interval(1, 3));
      input.add(new Interval(5, 7));
      input.add(new Interval(8, 12));
      System.out.print("Intervals after inserting the new interval: ");
      for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
         System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();

      input = new ArrayList<Interval>();
      input.add(new Interval(2, 3));
      input.add(new Interval(5, 7));
      System.out.print("Intervals after inserting the new interval: ");
      for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
         System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();

      input = new ArrayList<Interval>();
      input.add(new Interval(5, 7));
      input.add(new Interval(12, 13));
      System.out.print("Intervals after inserting the new interval: ");
      for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
         System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();
   }
}
