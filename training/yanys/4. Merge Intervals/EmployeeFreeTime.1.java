import sun.text.normalizer.UBiDiProps;

import java.util.*;

class Interval {
   int start;
   int end;

   public Interval(int start, int end) {
      this.start = start;
      this.end = end;
   }
};

class EmployeeFreeTime {

   public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {

      int start = schedule.get(0).get(0).start ;
      int end = schedule.get(0).get(schedule.get(0).size()-1).end ;
      for(int i=1; i< schedule.size(); i++){
         start = Math.min(schedule.get(i).get(0).start, start);
         end = Math.max(schedule.get(i).get(schedule.get(i).size()-1).end, end);
      }

      List<Interval> result = new ArrayList<>();
      // TODO: Write your code here
       result = findFreeTime(schedule.get(0), start, end);


      for(int i = 1; i < schedule.size(); i++ ){
         List<Interval> mutualFreeTime = result;
         List<Interval> freeTime = findFreeTime(schedule.get(i), start, end);
         result = new ArrayList<>();

         int n1=0, n2=0;
         Interval p1, p2;
         while( n1 < freeTime.size() && n2 < mutualFreeTime.size()){
            p1 = freeTime.get(n1);
            p2 = mutualFreeTime.get(n2);

            if( p1.start <  p2.end  && p2.start <  p1.end )
               result.add(new Interval(
                  Math.max(p1.start, p2.start),
                  Math.min(p1.end, p2.end)
               ));

            if( p1.end >= p2.end ) n2++;

            if (p2.end >= p1.end ) n1 ++;

         }
      }

      return result;
   }

   public static List<Interval> findFreeTime(List<Interval> schedule, int start, int end)
   {
      List<Interval> freeTime= new ArrayList<>();

      if ( start < schedule.get(0).start)
         freeTime.add(new Interval(start,schedule.get(0).start ));

      for(int i = 0; i < schedule.size()-1; i++){
         if((schedule.get(i).end < schedule.get(i+1).start))
            freeTime.add(new Interval(schedule.get(i).end, schedule.get(i+1).start));
      }

      if ( end > schedule.get(schedule.size()-1).end)
         freeTime.add(new Interval(schedule.get(schedule.size()-1).end, end));

      return freeTime;
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
