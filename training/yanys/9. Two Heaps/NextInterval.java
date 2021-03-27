import java.util.*;

class Interval {
   int start = 0;
   int end = 0;

   Interval(int start, int end) {
      this.start = start;
      this.end = end;
   }
}

class NextInterval {

   public static int[] findNextInterval(Interval[] intervals) {
      int[] result = new int[intervals.length];
      PriorityQueue<Integer>  minIntervalStartHeap = new PriorityQueue<> ((i1, i2) -> intervals[i1].start - intervals[i2].start);
      PriorityQueue<Integer>  minIntervalEndHeap = new PriorityQueue<> ((i1, i2) -> intervals[i1].end - intervals[i2].end);

      for(int i =0; i < intervals.length; i++) {
         minIntervalStartHeap.offer(i);
         minIntervalEndHeap.offer(i);
      }
      while(!minIntervalEndHeap.isEmpty()) {
         int i = minIntervalEndHeap.poll();
         result[i] = -1;
         while(!minIntervalStartHeap.isEmpty()){
            int j = minIntervalStartHeap.poll();
            if( intervals[i].end <=  intervals[j].start ){
               result[i] = j;
               minIntervalStartHeap.add(j);
               break;
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
      int[] result = NextInterval.findNextInterval(intervals);
      System.out.print("Next interval indices are: ");
      for (int index : result)
         System.out.print(index + " ");
      System.out.println();

      intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
      result = NextInterval.findNextInterval(intervals);
      System.out.print("Next interval indices are: ");
      for (int index : result)
         System.out.print(index + " ");
   }
}