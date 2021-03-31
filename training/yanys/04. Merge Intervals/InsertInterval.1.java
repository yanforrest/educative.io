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
      List<Interval> mergedIntervals = new ArrayList<>();
      //TODO: Write your code here
      if(intervals.size() < 1){
         mergedIntervals.add(newInterval);
         return mergedIntervals;
      }

      Iterator<Interval> intervalItr = intervals.listIterator();
      Interval next = null;
      int start = newInterval.start, end = newInterval.end;

      while(intervalItr.hasNext()){
        next=intervalItr.next();

        if(start > next.end || end < next.start){
           mergedIntervals.add(next);
           continue;
        }else {
           start=Math.min(next.start, start);
           end = Math.max(next.end, end);
        }
      };
      mergedIntervals.add(new Interval(start, end));

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

   }
}
