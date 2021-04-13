import java.util.*;

class Interval {
   int start;
   int end;

   public Interval(int start, int end) {
      this.start = start;
      this.end = end;
   }
};

class EmployeeInterval{
   Interval interval;
   int employeeIndex;
   int intervalIndex;

   public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex){
      this.interval = interval ;
      this.employeeIndex = employeeIndex;
      this.intervalIndex = intervalIndex;
   }
};


class EmployeeFreeTime {

   public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {

      List<Interval> result = new ArrayList<>();
      // TODO: Write your code here
      PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>((a, b) ->Integer.compare(a.interval.start, b.interval.start));

      for( int employeeIndex = 0; employeeIndex < schedule.size(); employeeIndex ++ ) {
         minHeap.add(new EmployeeInterval(schedule.get(employeeIndex).get(0),employeeIndex, 0 ));
      }


      EmployeeInterval cur= minHeap.poll();
      if(cur.intervalIndex < schedule.get(cur.employeeIndex).size()-1 )
         minHeap.add(new EmployeeInterval(schedule.get(cur.employeeIndex).get(cur.intervalIndex+1),cur.employeeIndex, cur.intervalIndex+1 ));

      while(!minHeap.isEmpty()){
         EmployeeInterval next= minHeap.poll();
         if(next.intervalIndex < schedule.get(next.employeeIndex).size()-1 )
            minHeap.add(new EmployeeInterval(schedule.get(next.employeeIndex).get(next.intervalIndex+1),next.employeeIndex, next.intervalIndex+1 ));

         if(cur.interval.end <  next.interval.start)
            result.add( new Interval(cur.interval.end, next.interval.start));

         if(cur.interval.end <  next.interval.end)
            cur = next;
      }

      return result;
   }

   public static void main(String[] args) {

      List<List<Interval>> input = new ArrayList<>();
      input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
      input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
      List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
      System.out.print("Free intervals: ");
      for (Interval interval : result)
         System.out.print("[" + interval.start + ", " + interval.end + "] ");
      System.out.println();

      input = new ArrayList<>();
      input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
      input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
      input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
      result = EmployeeFreeTime.findEmployeeFreeTime(input);
      System.out.print("Free intervals: ");
      for (Interval interval : result)
         System.out.print("[" + interval.start + ", " + interval.end + "] ");
      System.out.println();

      input = new ArrayList<>();
      input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
      input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
      input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
      result = EmployeeFreeTime.findEmployeeFreeTime(input);
      System.out.print("Free intervals: ");
      for (Interval interval : result)
         System.out.print("[" + interval.start + ", " + interval.end + "] ");

   }
}
