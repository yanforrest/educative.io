import java.util.*;

class Interval {
   int start;
   int end;

   public Interval(int start, int end) {
      this.start = start;
      this.end = end;
   }
};

class IntervalsIntersection {

   public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
      List<Interval> intervalsIntersection = new ArrayList<Interval>();
      // TODO: Write your code here
      boolean first = true, second = true;
      int i1 = 0, i2 = 0;
      Interval interval1= null, interval2 = null ;
      while(i1 < arr1.length || i2 < arr2.length){
         if( first  && i1 < arr1.length) interval1 = arr1[i1++];
         if( second && i2 < arr2.length) interval2 = arr2[i2++];

         if( interval1.start <= interval2.end && interval2.start <= interval1.end )
            intervalsIntersection.add(new Interval( Math.max( interval1.start, interval2.start), Math.min( interval1.end , interval2.end) ));

         first  = interval1.end <= interval2.end;
         second = interval2.end <= interval1.end;
      }

      return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
   }

   public static void main(String[] args) {
      Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
      Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
      Interval[] result = IntervalsIntersection.merge(input1, input2);
      System.out.print("Intervals Intersection: ");
      for (Interval interval : result)
         System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();

      input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
      input2 = new Interval[] { new Interval(5, 10) };
      result = IntervalsIntersection.merge(input1, input2);
      System.out.print("Intervals Intersection: ");
      for (Interval interval : result)
         System.out.print("[" + interval.start + "," + interval.end + "] ");
   }
}